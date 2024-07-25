package linkedLists;

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {

    Node head;
    int numElements;

    public MyLinkedList() {
        head = null;
        numElements = 0;
    }

    public int get(int index) {
        if (index >= numElements) {
            return -1;
        }
        int count = 0;
        Node temp = head;
        while (count < index) {
            temp = temp.next;
            count++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);
        numElements++;
    }

    public void addAtTail(int val) {
        if (numElements == 0) {
            addAtHead(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        numElements++;
    }

    public void addAtIndex(int index, int val) {
        if (index > numElements) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == numElements) {
            addAtTail(val);
            return;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (count < index) {
            prev = temp;
            temp = temp.next;
            count++;
        }

        prev.next = new Node(val, temp);
        numElements++;
    }

    public void deleteAtIndex(int index) {
        if (index >= numElements) {
            return;
        }
        if (index == 0) {
            head = head.next;
            numElements--;
            return;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (count < index) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = temp.next;
        numElements--;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        Node temp = head;
        while(temp != null) {
            a.append(temp.val).append(" --> ");
            temp = temp.next;
        }
        return a.substring(0, a.length() - 5);
    }
}

public class LC707_Design_Linked_List {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        System.out.println(obj.get(2));
        obj.addAtHead(3);
        System.out.println(obj);
        obj.addAtHead(2);
        System.out.println(obj);
        obj.addAtHead(1);
        System.out.println(obj);
        obj.addAtTail(4);
        System.out.println(obj);
        obj.addAtTail(5);
        System.out.println(obj);
        obj.addAtIndex(1, 4);
        System.out.println(obj);
        obj.deleteAtIndex(2);
        System.out.println(obj);
    }

}
