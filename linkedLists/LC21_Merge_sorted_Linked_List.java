package linkedLists;

public class LC21_Merge_sorted_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(6, new ListNode(8)))));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(7, new ListNode(9))))));
        System.out.println(l1.print(l1));
        System.out.println(l2.print(l2));
        System.out.println();
        System.out.println(l1.print(mergeTwoLists(l1, l2)));
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
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

        while(list1 != null) {
            list3.next = list1;
            list3 = list3.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            list3.next = list2;
            list3 = list3.next;
            list2 = list2.next;
        }

        return head.next;
    }
}
