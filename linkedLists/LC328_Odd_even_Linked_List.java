package linkedLists;

public class LC328_Odd_even_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(oddEvenList(l1)));


        l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(l1.print(l1));
        System.out.println(l1.print(oddEvenList(l1)));
    }

    static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode temp1 = head;
        ListNode head2 = head.next;
        ListNode temp2 = head2;
        while (temp2 != null && temp2.next != null) {
            temp1.next = temp1.next.next;
            temp1 = temp1.next;
            temp2.next = temp2.next.next;
            temp2 = temp2.next;
        }
        temp1.next = head2;
        return head;
    }
}
