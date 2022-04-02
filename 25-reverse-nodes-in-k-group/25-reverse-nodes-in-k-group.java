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
    ListNode oh;
    ListNode ot;
    
    ListNode th;
    ListNode tt;
    int size;
    
    public int getSize(ListNode curr){
        int ans=0;
        
        while(curr!=null){
            curr=curr.next;
            ans++;
        }
        
        return ans;
    }
    
    public void addFirst(ListNode nn){
        if(th==null){
            th=nn;
            tt=nn;
        } else {
            nn.next=th;
            th=nn;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        oh=null;
        ot=null;
        
        th=null;
        tt=null;
        size=0;
        
        ListNode curr=head;
        
        size=getSize(curr);
        
        if(k>size) return head;
        
        while(k<=size){
            int K=k;
            
            // k reverse -> remove first, add first
            while(K-->0){
                ListNode next=curr.next;
                curr.next=null;
                
                addFirst(curr);
                curr=next;
                
                size--;
            }
            
            // appending reversed lists to my original list
            
            if(oh==null){
                oh=th;
                ot=tt;
            } else {
                ot.next=th;
                ot=tt;
            }
            
            th=null;
            tt=null;
        }
        
        ot.next=curr;
        
        return oh;
    }
}