//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            new Solution().rearrangeEvenOdd(head);
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class Solution
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
    void rearrangeEvenOdd(Node head)
    {
         if(head == null || head.next==null){
			return;
		}

		Node dummy1 = new Node(-1);
		Node dummy2 = new Node(-1);

		Node odd = dummy1;
		Node even = dummy2;
		Node curr = head;
		int count = 1;

		while(curr!=null){
			Node nextOfCurr = curr.next;
			curr.next=null;
			
			if(count%2==1){
				// connect odd
				odd.next = curr;
				curr = nextOfCurr;
				odd = odd.next;
			} else {
				even.next = curr;
				curr = nextOfCurr;
				even = even.next;
			}

			count++;
		}

		Node oddHead = dummy1.next;
		Node evenHead = dummy2.next;

		// connect odd to even
		odd.next = evenHead;

		head = oddHead;
     }
}
