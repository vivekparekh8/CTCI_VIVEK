package linkedlists;

public class ReverseLL {
	 private ListNode head; 
	 public static ListNode reverseA(ListNode head) {
		 ListNode tempp = null;
		 ListNode current = head;
		 ListNode nextt ; 
		 while(current!=null){
			 nextt = current.next;
			 current.next = tempp;
			 tempp = current;
			 current = nextt;
		 }
		 head  = current;
		 return tempp;
		 
	 }
	public static ListNode reverse(ListNode head) {
		ListNode previous = null, current = head, next;
		// NULL head node1
		// [previous] [current] [next]
		while (current != null) {
			next = current.next; // set next to current's next
			current.next = previous; // set current's next to previous
			// update pointers
			previous = current; // advance previous to now be current
			current = next; // advance current to now be next
		}
		return previous; // this will be new head of the list
	}
	public void addToTheLast(ListNode node) {  
		  
		  if (head == null) {  
		   head = node;  
		  } else {  
		   ListNode temp = head;  
		   while (temp.next != null)  
		    temp = temp.next;  
		  
		   temp.next = node;  
		  }  
		 }  
		 public static void deleteNode(ListNode tbd){
			 if(tbd.next==null)
		     {   
				 tbd = null;
				 return;
		     }
			 else{
				 tbd.value = tbd.next.value;
				 tbd.next = tbd.next.next;
			 }
			 	 
		 }
		  
		public void printList(ListNode head) {  
		  ListNode temp = head;  
		  while (temp != null) {  
		   System.out.format("%d ", temp.value);  
		   temp = temp.next;  
		  }  
		  System.out.println();  
		 }  

	public static ListNode reverseRecurseProcess(ListNode head){
		// Base Case if head or head->next is null 
		if(head == null || head.next == null){
			return head;
		}
		ListNode temp = reverseRecurseProcess(head.next);
		System.out.println(head.value+"::"+temp.value); 
		head.next.next = head;
		head.next = null;
		
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLL list = new ReverseLL();  
		  // Creating a linked list  
		  ListNode head=new ListNode(5);  
		  list.addToTheLast(head);  
		  list.addToTheLast(new ListNode(6));  
		  list.addToTheLast(new ListNode(7));  
		  list.addToTheLast(new ListNode(1));  
		  list.addToTheLast(new ListNode(2));  
		  
		  list.printList(head);  
		  //Reversing LinkedList  
		  ListNode reverseHead=reverseRecurseProcess(head);  
		  System.out.println("After reversing");  
		  list.printList(reverseHead);
		  
		  deleteNode(reverseHead);
		  list.printList(reverseHead);

	}

}
class ListNode {
	Integer value = null;
	ListNode next;

	public ListNode(Integer num) {
		value = num;
	}
}
