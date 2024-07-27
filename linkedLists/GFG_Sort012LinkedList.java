package linkedLists;

public class GFG_Sort012LinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(2, new Node(2, new Node(1, new Node(2, new Node(0, new Node(2, new Node(2))))))));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(segregate(l1)));
    }

    static Node segregate(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node head0 = new Node(-1);
        Node head1 = new Node(-1);
        Node head2 = new Node(-1);
        Node temp0 = head0;
        Node temp1 = head1;
        Node temp2 = head2;

        while (head != null) {
            if (head.val == 0) {
                temp0.next = new Node(0);
                temp0 = temp0.next;
            } else if (head.val == 1) {
                temp1.next = new Node(1);
                temp1 = temp1.next;
            } else {
                temp2.next = new Node(2);
                temp2 = temp2.next;
            }
            head = head.next;
        }
        if (head1.next != null) {
            temp0.next = head1.next;
            temp1.next = head2.next;
        } else {
            temp0.next = head2.next;
        }
        return head0.next;

    }
}
