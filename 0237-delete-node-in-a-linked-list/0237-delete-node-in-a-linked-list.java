/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        
        ListNode nextOfNode = node.next;
        ListNode nextOfNextOfNode = nextOfNode.next;
        
        node.next = nextOfNextOfNode;
    }
}