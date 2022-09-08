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
    ListNode* th=nullptr;
    ListNode* tt=nullptr;
    
    void addFirst(ListNode* node){
        if(th==nullptr){
            th=tt=node;
        } else {
            node->next=th;
            th=node;
        }
    }
    
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* itr=head;   
        int curr_node=1;
        ListNode* left_prev=nullptr;
        
        while(itr){
            ListNode* itrKaNext=itr->next;
            
            if(curr_node<left){
                left_prev=itr;
            } else if(curr_node>=left && curr_node<=right){
                itr->next=nullptr;
                addFirst(itr);
            } else {
                if(left_prev==nullptr){
                    head=th;
                } else {
                    left_prev->next=th;
                }
                
                tt->next=itr;
                break;
            }
            
            itr=itrKaNext;
            curr_node++;
        }
        
        if(itr==nullptr){
            if(left_prev==nullptr){
                head=th;
            } else {
                left_prev->next=th;
            }

            tt->next=itr;
        }
        return head;
    }
};