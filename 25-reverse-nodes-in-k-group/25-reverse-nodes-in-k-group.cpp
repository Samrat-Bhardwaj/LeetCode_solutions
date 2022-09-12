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
    ListNode* thead2=nullptr;
    ListNode* ttail2=nullptr;

    void addFirst(ListNode* node){
        if(thead2==nullptr){
            thead2=ttail2=node;
        } else {
            node->next=thead2;
            thead2=node;
        }
    }
    
    int length(ListNode* head){
        ListNode* temp=head;

        int ans=0;
        while(temp){
            ans++;
            temp=temp->next;
        }

        return ans;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head==nullptr || head->next==nullptr || k<=1){
            return head;
        }

        int l=length(head);

        if(l<k){
            return head;
        }

        ListNode* curr=head;

        ListNode* oh=nullptr;
        ListNode* ot=nullptr;

        int K=k;

        while(curr && l>=k){
            while(K-- > 0){
                ListNode* currKanext=curr->next;
                curr->next=nullptr;

                addFirst(curr);
                curr=currKanext;
            }

            if(oh==nullptr){
                oh=thead2;
                ot=ttail2;
            } else {
                ot->next=thead2;
                ot=ttail2;
            }

            thead2=nullptr;
            ttail2=nullptr;

            l-=k;
            K=k;
        }

        ot->next=curr;
        return oh;
    }
};