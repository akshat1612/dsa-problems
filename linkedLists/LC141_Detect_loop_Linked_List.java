package linkedLists;

public class LC141_Detect_loop_Linked_List {
    public static void main(String[] args) {
        ListNode node = new ListNode(5, null);
        ListNode nodeC = new ListNode(8, new ListNode(9, node));
        ListNode nodeA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, nodeC))));
        node.next = nodeC;
        System.out.println("has Cycle ==> " + hasCycle(nodeA));
    }

    static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
            if(head == fast) {
                return true;
            }
        }
        return false;
    }
}
