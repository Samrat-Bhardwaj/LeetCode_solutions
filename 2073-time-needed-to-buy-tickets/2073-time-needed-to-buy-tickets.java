class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> que=new ArrayDeque<>();
        
        int n=tickets.length;
        
        for(int i=0; i<n; i++){
            if(i==k){
                que.add(-1 * tickets[i]);
            } else {
                que.add(tickets[i]);
            }
        }
        
        int time=0;
        while(que.size()>0){
            int front_ele=que.remove();
            
            if(front_ele==-1) return time+1;
            
            if(front_ele<0){
                front_ele++;
            } else {
                front_ele--;
            }
            
            if(front_ele!=0){
                que.add(front_ele);
            }
            
            time++;
        }
        return time;
    }
}