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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            // save next pointer 
            ListNode nextOfCurr = curr.next;
            
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
}