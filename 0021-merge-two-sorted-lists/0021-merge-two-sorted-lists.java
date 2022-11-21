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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
       ListNode p1 = list1;
       ListNode p2 = list2;

       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;

       while(p1!=null && p2!=null){
        ListNode np1 = p1.next;
        ListNode np2 = p2.next;

        if(p1.val < p2.val){
            curr.next = p1;
            p1 = np1;
        } else {
            curr.next = p2;
            p2 = np2;
        }

        curr=curr.next;
       }

        if(p1==null){
            curr.next = p2;
        }

        if(p2==null){
            curr.next = p1;
        }    

        return dummy.next;
	}
}