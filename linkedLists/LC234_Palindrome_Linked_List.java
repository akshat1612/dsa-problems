package linkedLists;

public class LC234_Palindrome_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(l1.print(l1));
        System.out.println("Palindrome --> " + isPalindrome(l1));
        System.out.println();

        l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        System.out.println(l1.print(l1));
        System.out.println("Palindrome --> " + isPalindrome(l1));
        System.out.println();

        l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(l1.print(l1));
        System.out.println("Palindrome --> " + isPalindrome(l1));
        System.out.println();
    }

    static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        while(newHead != null) {
            if(newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
