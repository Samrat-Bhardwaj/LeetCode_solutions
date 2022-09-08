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
            while(curr_node>=left && curr_node<=right){
                ListNode* itrKaNext=itr->next;
                itr->next=nullptr;
                addFirst(itr);
                
                itr=itrKaNext;
                curr_node++;
            }
            
            if(curr_node>right){
                if(left_prev==nullptr){ // head
                    head=th;
                } else {
                    left_prev->next=th;
                }
                
                tt->next=itr;
                break;
            }
            
            left_prev=itr;
            itr=itr->next;
            curr_node++;
        }
        
        return head;
    }
};