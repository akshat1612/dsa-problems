package linkedLists;

import java.util.ArrayList;
import java.util.List;

public class GFG_TwoSumDoublyLinkedList {
    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(4);
        Node2 node4 = new Node2(5);
        Node2 node5 = new Node2(6);
        Node2 node6 = new Node2(8);
        Node2 node7 = new Node2(9);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;
        node7.next = null;
        node1.prev = null;
        System.out.println(node1.toString(node1));
        System.out.println(findPairsWithGivenSum(7, node1));
    }

    static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node2 head) {
        ArrayList<ArrayList<Integer>> ans =  new ArrayList<>();
        if(head.next == null) {
            return ans;
        }
        Node2 left = head, right = head;
        while(right.next != null) {
            right = right.next;
        }

        while(left.data < right.data) {
            int a = left.data + right.data;
            if(a == target) {
                ans.add(new ArrayList<>(List.of(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if (a > target) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }
        return ans;
    }
}
