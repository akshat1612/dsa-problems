package linkedLists;

public class LC25_Reverse_k_nodes_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(reverseKGroup(l1, 3)));
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(l2.print(reverseKGroup(l2, 4)));
    }

    static  ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode kNode = findKNode(temp, k);
            if(kNode == null) {
                prev.next = temp;
                break;
            }
            ListNode next = kNode.next;
            kNode.next = null;
            ListNode newHead = reverse(temp);
            if(temp == head) {
                head = newHead;
            }
            if(prev != null) {
                prev.next = newHead;
            }
            prev = temp;
            temp = next;
        }
        return head;
    }

    static ListNode findKNode(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode temp = head;
        while(temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
