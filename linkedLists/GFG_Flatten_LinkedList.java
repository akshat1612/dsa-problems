package linkedLists;

class Node3 {
    int data;
    Node3 next, bottom;

    Node3(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }


    Node3(int data, Node3 next) {
        this.data = data;
        this.next = next;
        this.bottom = null;
    }

    public String toString(Node3 head) {
        StringBuilder a = new StringBuilder();
        while (head != null) {
            a.append(head.data).append(" --> ");
            head = head.bottom;
        }
        return a.substring(0, a.length() - 5);
    }
}
public class GFG_Flatten_LinkedList {
    public static void main(String[] args) {
        Node3 node1 = new Node3(1);
        Node3 node2 = new Node3(2);
        Node3 node3 = new Node3(3);
        Node3 node4 = new Node3(4);
        Node3 node5 = new Node3(5);
        Node3 node6 = new Node3(6);
        Node3 node7 = new Node3(7);
        Node3 node8 = new Node3(8);
        Node3 node9 = new Node3(9);
        Node3 node10 = new Node3(10);
        Node3 node11 = new Node3(11);
        Node3 node12 = new Node3(12);

        node2.bottom = node10;
        node1.bottom = node7;
        node7.bottom = node11;
        node11.bottom = node12;
        node4.bottom = node9;
        node5.bottom = node6;
        node6.bottom = node8;
        node3.next = node2;
        node2.next = node1;
        node1.next = node4;
        node4.next = node5;

        System.out.println(node3.toString(node3));
        System.out.println(node3.toString(flatten(node3)));

    }

    static Node3 flatten(Node3 root) {
        if(root == null || root.next == null) {
            return root;
        }

        Node3 l1 = root;
        Node3 l2 = root.next;
        while(l2 != null) {
            l1 = merge2LL(l1, l2);
            l2 = l2.next;
        }
        return l1;
    }

    static Node3 merge2LL(Node3 l1, Node3 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        Node3 temp = new Node3(-1);
        Node3 ans = temp;
        while(l1 != null && l2 != null) {
            if(l1.data > l2.data) {
                temp.bottom = l2;
                l2 = l2.bottom;
            } else {
                temp.bottom = l1;
                l1 = l1.bottom;
            }
            temp = temp.bottom;
        }

        while(l1 != null) {
            temp.bottom = l1;
            l1 = l1.bottom;
            temp = temp.bottom;
        }
        while(l2 != null) {
            temp.bottom = l2;
            l2 = l2.bottom;
            temp = temp.bottom;
        }
        return ans.bottom;
    }
}
