//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static Node reverseList_(Node head) {
        Node prev = null;
        Node curr = head;
        
        while(curr!=null){
            // save next pointer 
            Node nextOfCurr = curr.next;
            
            // reverse pointer
            curr.next = prev;
            
            // move pointers to the next 2 nodes
            prev = curr;
            curr = nextOfCurr;
        }
        // head is now at prev
        head = prev;
        
        return head;
    }
    
    public static void rearrange(Node head)
    {
        int count = 0;
        
        Node dummy1 = new Node(-1);
        Node c1 = dummy1;
        Node dummy2 = new Node(-1);
        Node c2 = dummy2;
        
        Node p = head;
        
        while(p!=null){
            Node nextOfP = p.next;
            p.next = null;
            
            if(count%2 == 0){
                c1.next=p;
                p=nextOfP;
                c1=c1.next;
            } else {
                c2.next=p;
                p=nextOfP;
                c2=c2.next;
            }
            count++;
        }
        
        Node head1 = dummy1.next;
        Node head2 = dummy2.next;
        
        head2 = reverseList_(head2);
        c1.next = head2;
        
        head=head1;
    }
}
