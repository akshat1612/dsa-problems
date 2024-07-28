package linkedLists;

class Pair {
    ListNode h;
    ListNode t;
    Pair(ListNode head, ListNode tail) {
        this.h = head;
        this.t = tail;
    }
}
public class LC206_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(l1.print(l1));
        System.out.println();
        System.out.println(l1.print(reverseList(l1)));
    }

    static ListNode reverseList(ListNode head) {
        return reverse(head).h;
    }

    static Pair reverse(ListNode head) {

        if (head == null || head.next == null) {
            return new Pair(head, head);
        }
        ListNode n = head.next;
        head.next = null;
        Pair rev = reverse(n);
        rev.t.next = head;
        return new Pair(rev.h, head);
    }
}
