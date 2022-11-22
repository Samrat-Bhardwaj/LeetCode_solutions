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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(slow != fast){ // there is no cycle 
            return null;
        }

        // move slow back to head;
        slow=head;

        // keep moving at same pace
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow; 
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        
        while(curr.next!=null){
            curr = curr.next;
        }
        
        curr.next = headA;
        ListNode ans = detectCycle(headB);
        
        curr.next=null;
        return ans;
    }
}