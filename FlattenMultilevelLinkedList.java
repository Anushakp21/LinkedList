package linkedlist;

class Node1 {
    int data;
    Node next;
    Node child;

    Node1(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}

public class FlattenMultilevelLinkedList {

    // Method to flatten the multilevel linked list
    public static Node flattenList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                // Flatten the child list
                Node child = flattenList(current.child);
                Node next = current.next; // Save the next node

                // Insert the flattened child list
                current.next = child;
                current.child = null; // Remove the child pointer

                // Find the tail of the flattened child list
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect the rest of the main list
                tail.next = next;
            }
            current = current.next; // Move to the next node
        }

        return head;
    }

    // Utility method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a multilevel linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Adding children
        head.next.child = new Node(6);
        head.next.child.next = new Node(7);
        head.next.child.next.child = new Node(8);

        System.out.println("Original List:");
        printList(head);

        // Flatten the list
        head = flattenList(head);

        System.out.println("\nFlattened List:");
        printList(head);
    }
}
