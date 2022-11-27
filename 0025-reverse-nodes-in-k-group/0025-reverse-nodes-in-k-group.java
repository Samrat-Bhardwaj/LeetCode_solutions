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
    
    void addFirst(ListNode nn){
        if(th == null){
            th = nn;
            tt = nn;
        } else {
            nn.next = th;
            th = nn;
        }
    }
    
    int getSize(ListNode head){
        ListNode curr = head;
        
        int ans = 0;
        while(curr!=null){
            ans++;
            curr=curr.next;
        }
        
        return ans;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        oh = null;
        ot = null;
        
        th = null;
        tt = null;
        
        int size = getSize(head);
        ListNode curr = head;
        // base case ()
        
        while(size>=k){
            // reverse in pair of k
            int K=k;
            while(K-- > 0){
                ListNode nextOfCurr = curr.next;
                curr.next = null;
                
                addFirst(curr);
                curr = nextOfCurr;
                
                size--;
            }
            
            // add th,tt to my original
            if(oh==null){
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            
            th = null;
            tt = null;
        }
        
        ot.next = curr;
        
        return oh;
    }
}