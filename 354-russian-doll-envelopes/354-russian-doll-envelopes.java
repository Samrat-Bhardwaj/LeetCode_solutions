class Solution {
    public int BS(ArrayList<int[]> dp, int ele){
        int si=0;
        int ei=dp.size()-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(dp.get(mid)[1]<ele){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        return si;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        
        Arrays.sort(envelopes,(int[] a, int [] b)->{
           if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0]; // width  
        });
        
        ArrayList<int[]> dp=new ArrayList<>();
        
        
        for(int i=0; i<n; i++){
            int nwidth=envelopes[i][0];
            int nheight=envelopes[i][1];
            
            int pos=BS(dp,nheight);
            // if(dp.size()>0)
            // System.out.println(dp.get(dp.size()-1)[0]+" "+nwidth);
            if(pos==dp.size() && (dp.size()==0 || (dp.get(dp.size()-1)[0]<nwidth))){
                dp.add(new int[]{nwidth,nheight});
            } else if(pos<dp.size()){
                dp.set(pos,new int[]{nwidth,nheight});
            }
        }
        
        return dp.size();
    }
    
}