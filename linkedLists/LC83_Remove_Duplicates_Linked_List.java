package linkedLists;

public class LC83_Remove_Duplicates_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(5))))));
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        ListNode l3 = new ListNode(1, new ListNode(1, new ListNode(1)));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(deleteDuplicates(l1)));
        System.out.println();
        System.out.println(l2.print(l2));
        System.out.println(l2.print(deleteDuplicates(l2)));
        System.out.println();
        System.out.println(l2.print(l3));
        System.out.println(l2.print(deleteDuplicates(l3)));
    }

    static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head, prev = null;
        while(temp.next != null) {
            if(temp.val == temp.next.val) {
                if(temp == head) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

}
