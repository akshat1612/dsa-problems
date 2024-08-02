package linkedLists;

public class LC142_Return_starting_of_loop_Linked_List {
    public static void main(String[] args) {
        ListNode node = new ListNode(5, null);
        ListNode nodeC = new ListNode(8, new ListNode(9, node));
        ListNode nodeA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, nodeC))));
        node.next = nodeC;
        System.out.println("Starting of loop - " + detectCycle(nodeA).print());
    }

    static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
