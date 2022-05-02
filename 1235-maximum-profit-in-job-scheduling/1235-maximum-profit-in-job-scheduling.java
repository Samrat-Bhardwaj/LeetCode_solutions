class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        
        int[][] jobs=new int[n][3];
        
        for(int i=0; i<n; i++){
            jobs[i][0]=startTime[i];            
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        
        Arrays.sort(jobs,(int[] a, int[] b)->{
            return a[1] - b[1];
        });
        
        // {et,profit}
        // end time vs profit
        
        ArrayList<int[]> etp=new ArrayList<>();
        etp.add(new int[]{0,0});
        
        for(int i=0; i<n; i++){
            int[] job=jobs[i];
            
            int st=job[0];
            int et=job[1];
            int p=job[2];
            
            int j=-1;
            for(j=etp.size()-1; j>=0; j--){
                if(etp.get(j)[0]<=st){
                    break;
                }
            }
            
            int currProfit=etp.get(j)[1]+p;
            
            if(etp.get(etp.size()-1)[1]<currProfit){
                etp.add(new int[]{et,currProfit});
            }
        }
        
        return etp.get(etp.size()-1)[1];
    }
}