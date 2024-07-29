package linkedLists;

public class GFG_Add_1_To_number {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(2, new Node(3)));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(addOne(l1)));
        System.out.println();
        l1 = new Node(1, new Node(9, new Node(3)));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(addOne(l1)));
        System.out.println();
        l1 = new Node(1, new Node(8, new Node(9)));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(addOne(l1)));
        System.out.println();
        l1 = new Node(1, new Node(9, new Node(9)));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(addOne(l1)));
        System.out.println();

        l1 = new Node(9, new Node(9, new Node(9)));
        System.out.println(l1.toString(l1));
        System.out.println(l1.toString(addOne(l1)));
        System.out.println();
    }

    static Node addOne(Node head) {
        int ans = recurAdd(head);
        if(ans == 1) {
            Node n = new Node(1);
            n.next = head;
            return n;
        }
        return head;
    }

    static int recurAdd(Node head) {
        if(head.next == null) {
            int val = head.val;
            head.val = (val + 1) % 10;
            return (val + 1) / 10;
        }
        int ansAfter = recurAdd(head.next);
        int val = head.val;
        head.val = (val + ansAfter) % 10;
        return (val + ansAfter) / 10;
    }
}
