package linkedlist;

public class PalindromeLinkedList {

	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secondHalfHead = reverseList(slow);

		Node firstHalfHead = head;
		Node reversedSecondHalf = secondHalfHead;
		boolean palindrome = true;

		while (reversedSecondHalf != null) {
			if (firstHalfHead.data != reversedSecondHalf.data) {
				palindrome = false;
				break;
			}
			firstHalfHead = firstHalfHead.next;
			reversedSecondHalf = reversedSecondHalf.next;
		}
		reverseList(secondHalfHead);

		return palindrome;
	}

	public static Node reverseList(Node head) {
		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}

		return prev;
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
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);

		System.out.println("Original Linked List:");
		printList(head);

		boolean result = isPalindrome(head);

		if (result) {
			System.out.println("The linked list is a palindrome.");
		} else {
			System.out.println("The linked list is not a palindrome.");

		}
	}
}

