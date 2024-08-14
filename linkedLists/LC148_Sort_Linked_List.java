package linkedLists;

public class LC148_Sort_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(6, new ListNode(5, new ListNode(2))))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(sortList(l1)));
    }

    static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        return sort(head);
    }

    static ListNode sort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        ListNode l1 = sort(temp);
        ListNode l2 = sort(head);
        return mergeTwoLists(l1, l2);
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(-1);
        ListNode head = list3;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }

        if(list1 != null) {
            list3.next = list1;
        }
        if(list2 != null) {
            list3.next = list2;
        }

        return head.next;
    }

}
