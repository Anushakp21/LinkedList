package linkedlist;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class LinkedListCycle {
	
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; 
        }

        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;   
            
            if (slow == fast) { 
            	//find starting node
            	ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;        
            }
        }
        
        return null;  
    }
    
    public static void main(String[] args) {
    	 LinkedList<Integer> list = new LinkedList<Integer>();
         
         list.add(3); 
         list.add(2); 
         list.add(0); 
         list.add(-4); 
         
         System.out.println("Original LinkedList: " + list);
         
         ListNode head = new ListNode(3);
         ListNode node2 = new ListNode(2);
         ListNode node3 = new ListNode(0);
         ListNode node4 = new ListNode(-4);
         
         head.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = node2; 
        ListNode cycleStart = detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle detected, starting node value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
