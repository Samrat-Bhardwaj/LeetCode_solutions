/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==nullptr || head->next==nullptr){
            return head;
        }
        
        ListNode* curr=head;
     
        while(curr && curr->next){
            if(curr->val==curr->next->val){
                ListNode* currKaNext=curr->next;
                curr->next=nullptr;
                curr->next=currKaNext->next;
                
                currKaNext->next=nullptr; // not neccessory
            } 
            if(curr->next && curr->val!=curr->next->val){
                curr=curr->next;
            }
        }
        
        return head;
    }
};