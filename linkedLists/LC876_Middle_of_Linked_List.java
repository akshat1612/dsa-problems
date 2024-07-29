package linkedLists;

public class LC876_Middle_of_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))));
        System.out.println(l1.print(l1));
        System.out.println(middleNode(l1).print());
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(middleNode(l2).print());

    }

    static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
}
