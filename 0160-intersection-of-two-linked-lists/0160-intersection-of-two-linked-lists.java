/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head){
        int len=0;
        ListNode curr = head;
        
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getLength(headA);
        int size2 = getLength(headB);
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        if(size1 > size2){
            int diff = size1- size2;
            while(diff>0 && p1!=null){
                p1=p1.next;
                diff--;
            }
        } else {
            int diff = size2 - size1;
            while(diff>0 && p2!=null){
                p2=p2.next;
                diff--;
            }
        }
        
        while(p1!=null && p2!=null){
            if(p1==p2) return p1;
            p1=p1.next;
            p2=p2.next;
        }
        
        return null;
    }
}