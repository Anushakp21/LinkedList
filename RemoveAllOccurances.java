package linkedlist;

public class RemoveAllOccurances {

    public static Node removeOccurrences(Node head, int value) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
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
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        int valueToRemove = 3;

        head = removeOccurrences(head, valueToRemove);

        System.out.println("\nList after removing occurrences of " + valueToRemove + ":");
        printList(head);
    }
}
