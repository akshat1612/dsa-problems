package linkedLists;

public class LC160_Intersection_of_Y_Linked_List {
    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode nodeB = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode nodeC = new ListNode(8, new ListNode(9, new ListNode(10)));
        nodeA.next.next.next.next = nodeC;
        nodeB.next.next.next = nodeC;
        System.out.println(nodeA.print(nodeA));
        System.out.println(nodeB.print(nodeB));
        System.out.println(nodeB.print(getIntersectionNode(nodeA, nodeB)));
        System.out.println();
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tempA = headA, tempB = headB;
        while(tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
            lenA++;
            lenB++;
        }
        while(tempA != null) {
            tempA = tempA.next;
            lenA++;
        }
        while(tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        for(int i = 0; i < (lenA - lenB); i++) {
            headA = headA.next;
        }

        for(int i = 0; i < (lenB - lenA); i++) {
            headB = headB.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
