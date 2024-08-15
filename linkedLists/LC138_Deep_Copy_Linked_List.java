package linkedLists;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Node4 {
    int val;
    Node4 next;
    Node4 random;

    public Node4(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void print() {
        Node4 temp = this;
        while (temp != null) {
            Node4 val = Objects.requireNonNullElse(temp.random, new Node4(-1));
            System.out.print("(" + temp.val + " , " + val.val + ") --> ");
            temp = temp.next;
        }
    }
}

public class LC138_Deep_Copy_Linked_List {
    public static void main(String[] args) {

        Node4 node7 = new Node4(7);
        Node4 node13 = new Node4(13);
        Node4 node11 = new Node4(11);
        Node4 node10 = new Node4(10);
        Node4 node1 = new Node4(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node1.next = null;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        node7.print();
        System.out.println("   Original    ");
        System.out.println();
        copyRandomList(node7).print();
        System.out.println("   Deep Copy   ");
    }

    static Node4 copyRandomList(Node4 head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Node4 a = new Node4(head.val);
            if (head.random == head) {
                a.random = a;
            }
            return a;
        }
        Map<Node4, Node4> Node4Map = new HashMap<>();
        Node4 temp = head;
        Node4 newList = new Node4(-1);
        Node4 prev = newList;
        while (temp != null) {
            Node4 a = new Node4(temp.val);
            Node4Map.put(temp, a);
            prev.next = a;
            prev = a;
            temp = temp.next;
        }
        prev = newList.next;
        while (head != null) {
            prev.random = Node4Map.get(head.random);
            prev = prev.next;
            head = head.next;
        }
        return newList.next;
    }

}
