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
    ListNode* middleNode2(ListNode* head) {
    if(head==nullptr || head->next==nullptr){
        return head;
    }

    ListNode* slow=head;
    ListNode* fast=head;

    while(fast->next!=NULL && fast->next->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }        

    return slow;
}


ListNode* reverseList(ListNode* head) {
    if(head==nullptr || head->next==nullptr){
        return head;
    }        

    ListNode* curr=head;
    ListNode* prev=nullptr;

    while(curr!=nullptr){
        ListNode* currKaNext=curr->next;
        
        curr->next=prev;

        prev=curr;
        curr=currKaNext;
    }

    return prev;
}
    bool isPalindrome(ListNode* head) {
        if(head==nullptr || head->next==nullptr){
            return true;
        }

        // find mid
        ListNode* midNode=middleNode2(head);
        // create L2
        ListNode* head2=midNode->next;
        midNode->next=nullptr;

        head2=reverseList(head2);

        // compare List 1 and list 2
        ListNode* itr1=head;
        ListNode* itr2=head2;

        while(itr1 && itr2){
            if(itr1->val != itr2->val){
                return false;
            }
            itr1=itr1->next;
            itr2=itr2-> next;
        }

        return true;
    }
};