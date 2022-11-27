//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
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
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        if(head == null || head.next==null){
			return head;
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
			
			if(curr.data % 2==1){
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

        if(evenHead == null){
            return oddHead;
        }
		// connect odd to even
		even.next = oddHead;

		return evenHead;
    }
}