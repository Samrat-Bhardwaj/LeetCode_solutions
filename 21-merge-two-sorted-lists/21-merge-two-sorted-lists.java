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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode i=head1;
        ListNode j=head2;
        
        ListNode head=new ListNode(-1);
        ListNode k=head;
        
        while(i!=null && j!=null){
            ListNode ikaNext=i.next;
            ListNode jkaNext=j.next;
            
            if(i.val < j.val){
                k.next=i;
                i.next=null;
                i=ikaNext;
            } else {
                k.next=j;
                j.next=null;
                j=jkaNext;
            }
            
            k=k.next;
        }
        
        if(i!=null){
            k.next=i;
        }
        
        if(j!=null){
            k.next=j;
        }
        
        return head.next;
    }
}