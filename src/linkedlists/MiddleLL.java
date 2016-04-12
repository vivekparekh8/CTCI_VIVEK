package linkedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MiddleLL {
	 private ListNode head;
	 public static void alternateJoinLists(ListNode a, ListNode b){
		 ListNode p1 = a;
		 ListNode p2 = b;
		 
		 
		 while(a!=null && b!=null){
			 ListNode temp1=p1.next;
			 ListNode temp2=p2.next;
			 
			 p1.next = temp2;
			 p2.next = temp1;
			 
			 p1 = temp1;
			 p2 = temp2;
		 }
	 }
	 public static ListNode mergeTwoSortedList(ListNode l1,ListNode l2){
		 ListNode p1 = l1;
	        ListNode p2 = l2;
	 
	        ListNode fakeHead = new ListNode(0);
	        ListNode p = fakeHead;
	 
	        while(p1 != null && p2 != null){
	          if(p1.value <= p2.value){
	              p.next = p1;
	              p1 = p1.next;
	          }else{
	              p.next = p2;
	              p2 = p2.next;
	          }
	 
	          p = p.next;
	        }
	 
	        if(p1 != null)
	            p.next = p1;
	        if(p2 != null)
	            p.next = p2;
	 
	        return fakeHead.next;
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
	public void printList(ListNode head) {  
		  ListNode temp = head;  
		  while (temp != null) {  
		   System.out.format("%d ", temp.value);  
		   temp = temp.next;  
		  }  
		  System.out.println();  
		 }  
	public static ListNode getMiddle(ListNode temp){
		ListNode a = temp;
		ListNode b = temp;
		int flag = 0,length=0;
		while(b.next!=null){
//			System.out.println("V"+a.value);
//			a = a.next;
//			b = b.next.next;
//			length++;
//			System.out.println("M"+ b.value);
			if (flag == 0) {
				b = b.next;
				flag = 1;
			} else if (flag == 1) {
				b = b.next;
				a = a.next;
				flag = 0;

			}
			length++;
		}
		System.out.println(length+1 +"is Length");
		return a;
		
	}
	public static boolean loopOrNot(ListNode temp){
		ListNode a = temp;
		ListNode b = temp;
		while(a.next!=null && b.next!=null){
			if(b.next == a){
				return true;
			}
			a=a.next;
			b=b.next.next;
		}
		
		return false;
		
	}
	public static ListNode nthFromLast(ListNode temp,int n){
		ListNode slow = temp;
		ListNode fast = temp;
		try{
			
				for(int i=0;i<n;i++){
					fast = fast.next;
				}
				while(fast.next!=null){
					slow = slow.next;
					fast = fast.next;
				}
				
			
		}
		catch(Exception e){
			System.out.println("Invalid entry");
		}
		
		return slow;
	}
	public static MiddleLL addTwoLL(ListNode a,ListNode b){
		MiddleLL newList = new MiddleLL();
		int carry = 0;
		int sum = 0;
		while(a!=null || b!=null){
			sum = carry;
			if(a!=null){
				sum  =sum+ a.value;
				a=a.next;
			}
			if(b!=null){
				sum  =sum+ b.value;
				b=b.next;
			}
			carry = 0;
			if(sum>=10){
				//System.out.println("inside if "+sum);
				carry = sum / 10;
				sum = sum % 10;
			}
			System.out.println("Each "+sum);
			ListNode temp = new ListNode(sum);
			newList.addToTheLast(temp);
			
		}
		if(carry!=0){
			ListNode temp = new ListNode(carry);
			newList.addToTheLast(temp);
		}
		
		return newList;
	}
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		   if(lists.size() == 0)
               return null;
           PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>() {
        	   public int compare(ListNode o1, ListNode o2) {
                   return Integer.compare(o1.value, o2.value);
               }
           });
           for(ListNode node: lists) {
               if(node != null)
               { 
            	   queue.add(node);
            	   System.out.println("1st:"+node.value);
               }
           }
           if(queue.isEmpty())
               return null;

           ListNode result = queue.poll();
           if(result.next != null)
               queue.add(result.next);

           ListNode cur = result;

           while(!queue.isEmpty()) {
        	   System.out.println("PEEK"+queue.peek().value);
               ListNode node = queue.poll();
               if(node.next != null) {
                   queue.add(node.next);
                   node.next = null;
               }
               cur.next = node;
               cur = cur.next;
           }

           return result;
       }

      
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleLL list = new MiddleLL();  
		  // Creating a linked list  
		  ListNode head=new ListNode(5);  
		  list.addToTheLast(head);  
		  list.addToTheLast(new ListNode(6));  
		  list.addToTheLast(new ListNode(7));  
		  list.addToTheLast(new ListNode(1));  
		  list.addToTheLast(new ListNode(2));  
		  //list.addToTheLast(head);
		  //list.printList(head);  
		 
		  //System.out.println(loopOrNot(head));
		  
		  //System.out.println(getMiddle(head).value);
		  //System.out.println("Nth fromLast : "+nthFromLast(head, 3).value);
		  MiddleLL list1 = new MiddleLL();
		  ListNode head1=new ListNode(6);  
		  list1.addToTheLast(head1);  
		  list1.addToTheLast(new ListNode(3));  
		  list1.addToTheLast(new ListNode(5));  
		  list1.addToTheLast(new ListNode(9));  
		  
		  ListNode h1 =ReverseLL.reverse(head);
		  ListNode h2 =ReverseLL.reverse(head1);
		  System.out.println(h1.value+":"+h2.value);
		  MiddleLL added= addTwoLL(h1,h2); 
		  ListNode result =ReverseLL.reverse(added.head);
		  added.printList(result);
		  
		  MiddleLL sortedlist1 = new MiddleLL();
		  sortedlist1.addToTheLast(new ListNode(1));  
		  sortedlist1.addToTheLast(new ListNode(25));  
		 // sortedlist1.addToTheLast(new ListNode(40));  
		 // sortedlist1.addToTheLast(new ListNode(80)); 
		  
		  MiddleLL sortedlist2 = new MiddleLL();
		  sortedlist2.addToTheLast(new ListNode(6));  
		  sortedlist2.addToTheLast(new ListNode(7));  
		  sortedlist2.addToTheLast(new ListNode(8));  
		  sortedlist2.addToTheLast(new ListNode(10));
		  //System.out.println("LL2"+sortedlist1.head.next.value);
		  System.out.println("---------");
		  ArrayList<ListNode> lists = new ArrayList<ListNode>();
		  lists.add(sortedlist1.head);
		  lists.add(sortedlist2.head);
		  System.out.println(mergeKLists(lists).toString());
		  System.out.println("First of sorted merge :"+mergeTwoSortedList(sortedlist1.head,sortedlist2.head).next.value);
		  
		  
	}

}
