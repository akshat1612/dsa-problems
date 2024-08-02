package linkedLists;

public class GFG_RemoveAllOccurencesDoublyLinkedList {
    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(2);
        Node2 node6 = new Node2(5);
        Node2 node7 = new Node2(6);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;
        node7.next = null;
        node1.prev = null;
        System.out.println(node1.toString(node1));
        System.out.println(node1.toString(deleteAllOccurOfX(node1, 2)));
    }

    static  Node2 deleteAllOccurOfX(Node2 head, int x) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            if(head.data == x) {
                return null;
            } else {
                return head;
            }
        }

        Node2 temp = head;
        while(temp != null) {
            if(temp.data == x) {
                if(head == temp) {
                    head = head.next;
                } else if(temp.next == null) {
                    temp.prev.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}
