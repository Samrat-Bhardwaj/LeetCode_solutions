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
    public ListNode middleNode_(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList_(ListNode head) {
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
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode curr = dummy;

        while(p1!=null && p2!=null){
            ListNode nextOfP1=p1.next;
            p1.next = null;

            ListNode nextOfP2 = p2.next;
            p2.next=null;

            // first add p1
            curr.next=p1;
            p1 = nextOfP1;
            curr = curr.next;

            // then add p2
            curr.next = p2;
            p2 = nextOfP2;
            curr = curr.next;
        }

        curr.next=p1;

        return dummy.next;
    }

    public void reorderList(ListNode head) {
        // find mid
        ListNode mid = middleNode_(head);

        // break into two
        ListNode head2 = mid.next;
        mid.next=null;

        // reverse the second ll
        head2 = reverseList_(head2);

        // merge two lists 
        head = merge(head,head2);
    }
}