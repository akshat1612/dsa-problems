package linkedLists;

public class LC61_Rotate_by_k_nodes_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(rotateRight(l1, 3)));
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(l2.print(rotateRight(l2, 2)));
    }

    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;
        int len = 0;
        while(temp != null) {
            len++;
            prev = temp;
            temp = temp.next;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }
        temp = head;
        int count = len - k;
        while(count > 1) {
            temp = temp.next;
            count--;
        }

        ListNode nt = temp.next;
        temp.next= null;
        prev.next = head;
        return nt;
    }
}
