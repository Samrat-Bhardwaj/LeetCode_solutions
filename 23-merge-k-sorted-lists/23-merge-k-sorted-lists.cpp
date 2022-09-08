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
class compare {
    public:
        bool operator()(ListNode* a, ListNode* b){
            return a->val > b->val;  // node with smaller val will be on top
            // return a->val < b->val;  // node with greater val will be on top
        }
};

ListNode* mergeKLists(vector<ListNode*>& lists) {
    if(lists.size()==0) return nullptr;

    priority_queue<ListNode*,vector<ListNode*>,compare> pq;

    // PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->{
    //     return a.val - b.val; // smaller val node on top
    //     return b.val - a.val; // larger node on top
    // });

    for(int i=0; i<lists.size(); i++){
        ListNode* ith=lists[i];
        if(ith)
            pq.push(ith);
    }

    ListNode* dummy=new ListNode(-1);
    ListNode* itr=dummy;

    while(pq.size()){
        ListNode* top=pq.top(); pq.pop();

        itr->next=top;

        if(top->next){
            pq.push(top->next);
        }

        itr=itr->next;
    }

    return dummy->next;
}
};