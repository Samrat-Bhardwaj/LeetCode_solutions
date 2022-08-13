/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode currKaNext=curr.next;
            
            curr.next=prev;
            
            prev=curr;
            curr=currKaNext;
        }
        
        return prev;
    }
    
    public static ListNode joinLists(ListNode head1, ListNode head2){
        ListNode i=head1;
        ListNode j=head2;
        
        ListNode dummy=new ListNode(-1);
        ListNode k=dummy;
        
        int curr_step=0;
        
        while(i!=null && j!=null){
            ListNode iKaNext=i.next;
            ListNode jKaNext=j.next;
            
            if(curr_step%2==0){
                k.next=i;
                i.next=null;
                i=iKaNext;
            } else {
                k.next=j;
                j.next=null;
                j=jKaNext;
            }
            
            k=k.next;
            curr_step++;
        }
        
        if(i!=null){
            k.next=i;
        } 
        
        if(j!=null){
            k.next=j;
        }
        
        return dummy.next;
    }
    
    
    
    public void reorderList(ListNode head) {
        ListNode mid=getMid(head);
        ListNode head2=mid.next;
        
         // break into 2 parts
        mid.next=null;
       
        // reverse second part
        head2=reverse(head2);
        
        // combine both parts
        joinLists(head,head2);
    }
}