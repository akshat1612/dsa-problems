package linkedLists;

public class LC19_Remove_from_Nth_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode l2 = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(8, new ListNode(3))))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(removeNthFromEnd(l1, 3)));
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(l2.print(removeNthFromEnd(l2, 2)));
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return slow.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
