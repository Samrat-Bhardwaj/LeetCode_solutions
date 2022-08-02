class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            
            if(map.containsKey(ch)==true){
                int fre=map.get(ch);
                
                map.put(ch,fre+1);
            } else {
                map.put(ch,1);
            }
        }
        
        ArrayList<Character> keys=new ArrayList<>(map.keySet());
        
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->{
            return map.get(b) - map.get(a);
        });
        
        for(int i=0; i<keys.size(); i++){
            pq.add(keys.get(i));
        }
        
        
        StringBuilder sb=new StringBuilder();
        while(pq.size()>0){
            char c=pq.remove();
            
            int fre=map.get(c);
            
            while(fre>0){
                sb.append(c);
                fre--;
            }
        }
        
        return sb.toString();
    }
}