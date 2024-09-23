package linkedlist;

class Node {
    int data;
    Node next;
    Node random;
	Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
        this.child=child;    }
}

public class ClonedLinkedList {

    public static Node cloneList(Node head) {
        if (head == null) {
            return null;
        }

         Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

       current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

         Node original = head;
        Node copy = head.next;
        Node copyHead = copy;  

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;  
    }

     public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomData = (temp.random != null) ? temp.random.data : -1;
            System.out.println("Node data: " + temp.data + ", Random points to: " + randomData);
            temp = temp.next;
        }
    }
    }

