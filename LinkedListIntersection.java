package linkedlist;

public class LinkedListIntersection {
    
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection point
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null; 
    }

    public static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

     public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(3);
        headA.next = new Node(6);
        headA.next.next = new Node(9);
        headA.next.next.next = common;

        Node headB = new Node(4);
        headB.next = new Node(7);
        headB.next.next = common;

        System.out.println("List A:");
        printList(headA);
        System.out.println("List B:");
        printList(headB);

        Node intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection point at node with data: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}

