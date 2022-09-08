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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* dummy=new ListNode(-1);
        ListNode* itr=dummy;

        while(list1 && list2){
            if(list1->val < list2->val){
                itr->next=list1;
                list1=list1->next;
            } else {
                itr->next=list2;
                list2=list2->next;
            }

            itr=itr->next;
        }        

        if(list1){
            itr->next=list1;
        } 
        if(list2){
            itr->next=list2;
        }

        return dummy->next;
    }

    // leetcode 148 ============= 
    ListNode* sortList(ListNode* head) {
        if(head==nullptr || head->next==nullptr){
            return head;
        }

        ListNode* midNode=middleNode2(head);
        ListNode* head2=midNode->next;
        midNode->next=nullptr;

        return mergeTwoLists(sortList(head),sortList(head2));
    }
};