package linkedlist;

public class ReverseinGroups {

    public static Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) {
            return head; 
            }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        current = head;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k) {
            return head; 
            }


 current = head;
        count = 0;
        while (count < k) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current;      // Move prev to current node
            current = next;      // Move to the next node
            count++;
        }

         if (next != null) {
            head.next = reverseInGroups(next, k);
        }

          return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
         Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Original List:");
        printList(head);

         int k = 3;
        head = reverseInGroups(head, k);

        System.out.println("\nReversed List in groups of " + k + ":");
        printList(head);
    }
}

