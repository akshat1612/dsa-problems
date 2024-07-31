package linkedLists;

public class LC2095_Delete_Middle_of_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))));
        System.out.println(l1.print(l1));
        System.out.println(deleteMiddle(l1).print(l1));
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(deleteMiddle(l2).print(l2));

    }

    static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
