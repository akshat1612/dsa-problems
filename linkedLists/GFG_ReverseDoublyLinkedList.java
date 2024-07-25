package linkedLists;

class Node2 {
    int data;
    Node2 next, prev;

    Node2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


    Node2(int data, Node2 next) {
        this.data = data;
        this.next = next;
        this.prev = null;
    }

    public String toString(Node2 head) {
        StringBuilder a = new StringBuilder();
        while (head != null) {
            a.append(head.data).append(" --> ");
            head = head.next;
        }
        return a.substring(0, a.length() - 5);
    }
}

public class GFG_ReverseDoublyLinkedList {
    public static void main(String[] args) {
        Node2 ll = new Node2(1, new Node2(2, new Node2(3, new Node2(4, new Node2(5)))));
        System.out.println(ll.toString(ll));
        Node2 reverse = reverseDLL(ll);
        System.out.println(reverse.toString(reverse));
    }

    static Node2 reverseDLL(Node2 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node2 temp = head;
        Node2 prev = null;
        while (temp != null) {
            Node2 add = temp.prev;
            temp.prev = temp.next;
            temp.next = add;
            prev = temp;
            temp = temp.prev;
        }
        return prev;
    }
}
