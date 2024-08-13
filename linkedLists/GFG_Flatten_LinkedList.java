package linkedLists;

class Node3 {
    int data;
    Node3 next, bottom;

    Node3(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }


    Node3(int data, Node3 next) {
        this.data = data;
        this.next = next;
        this.bottom = null;
    }

    public String toString(Node3 head) {
        StringBuilder a = new StringBuilder();
        while (head != null) {
            a.append(head.data).append(" --> ");
            head = head.next;
        }
        return a.substring(0, a.length() - 5);
    }
}
public class GFG_Flatten_LinkedList {
    public static void main(String[] args) {
//        Node3
//        System.out.println(l1.toString(l1));
//        System.out.println(l1.toString(segregate(l1)));
    }

    static Node3 flatten(Node3 root) {
        if(root == null || root.next == null) {
            return root;
        }

        Node3 l1 = root;
        Node3 l2 = root.next;
        while(l2 != null) {
            l1 = merge2LL(l1, l2);
            l2 = l2.next;
        }
        return l1;
    }

    static Node3 merge2LL(Node3 l1, Node3 l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        Node3 temp = new Node3(-1);
        Node3 ans = temp;
        while(l1 != null && l2 != null) {
            if(l1.data > l2.data) {
                temp.bottom = l2;
                l2 = l2.bottom;
            } else {
                temp.bottom = l1;
                l1 = l1.bottom;
            }
            temp = temp.bottom;
        }

        while(l1 != null) {
            temp.bottom = l1;
            l1 = l1.bottom;
            temp = temp.bottom;
        }
        while(l2 != null) {
            temp.bottom = l2;
            l2 = l2.bottom;
            temp = temp.bottom;
        }
        return ans.bottom;
    }
}
