package linkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String print(ListNode listNode) {
        StringBuilder a = new StringBuilder();
        while (listNode != null) {
            a.append(listNode.val).append(" --> ");
            listNode = listNode.next;
        }
        return a.substring(0, a.length() - 5);
    }
}

public class LC2_Sum_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l1.print(l1));
        System.out.println(l2.print(l2));
        System.out.println("Sum is ---->");
        System.out.println(l3.print(l3));
        System.out.println();
        System.out.println();
        System.out.println();

        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        l3 = addTwoNumbers(l1, l2);
        System.out.println(l1.print(l1));
        System.out.println(l2.print(l2));
        System.out.println("Sum is ---->");
        System.out.println(l3.print(l3));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode head3 = new ListNode();
        ListNode temp3 = head3;

        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            ListNode temp = new ListNode(v % 10);
            carry = v / 10;
            temp3.next = temp;
            temp3 = temp;
            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            int v = l1.val + carry;
            ListNode temp = new ListNode(v % 10);
            carry = v / 10;
            temp3.next = temp;
            temp3 = temp;
            l1 = l1.next;
        }

        while (l2 != null) {
            int v = l2.val + carry;
            ListNode temp = new ListNode(v % 10);
            carry = v / 10;
            temp3.next = temp;
            temp3 = temp;
            l2 = l2.next;
        }
        if (carry != 0) {
            temp3.next = new ListNode(carry);
        }
        return head3.next;
    }
}
