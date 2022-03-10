class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n=buildings.length;
        
        int[][] arr=new int[2*n][2];
        
        int k=0;
        for(int i=0; i<n; i++){
            int sp=buildings[i][0];
            int ep=buildings[i][1];
            int h=buildings[i][2];
            
            arr[k][0]=sp;
            arr[k][1]=(-1)*h;
            
            k++;
            arr[k][0]=ep;
            arr[k][1]=h;
            k++;
        }
        
        Arrays.sort(arr, (int[] a, int [] b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        List<List<Integer>> ans=new ArrayList<>();
        
        int ch=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        
        for(int i=0; i<2*n; i++){
            int x=arr[i][0];
            int h=arr[i][1];
            
            if(h<0){ // starting point
                pq.add((-1)*h);
            } else {
                pq.remove(h);
            }
            
            int max_height=pq.peek();
            
            if(ch!=max_height){
                List<Integer> sans=new ArrayList<>();
                sans.add(x);
                sans.add(max_height);
                
                ans.add(sans);
                
                ch=max_height;
            }
        }
        
        return ans;
        
    }
}