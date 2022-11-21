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
    public int getSize(ListNode head){
        int len =0;
        ListNode curr = head;

        while(curr!=null){
            curr = curr.next;
            len++;
        }

        return len;
    }

    public ListNode getAt(ListNode head, int idx){
        ListNode curr = head;

        for(int i=0; i<idx; i++){
            curr=curr.next;
        }

        return curr;
    }

    public ListNode reverseList(ListNode head) {
        int n = getSize(head); 
        
        int i=0;
        int j=n-1;

        while(i<j){
            ListNode nodeAtI = getAt(head, i);
            ListNode nodeAtJ = getAt(head, j);

            int valAtI = nodeAtI.val;
            int valAtJ = nodeAtJ.val;

            nodeAtI.val = valAtJ;
            nodeAtJ.val = valAtI;

            i++;
            j--;
        }

        return head;
    }
}