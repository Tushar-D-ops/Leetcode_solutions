class Solution {
    public long minCost(String s, int[] cost) {
        HashMap<Character,Long>map=new HashMap<>();
        long total=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),(long)(map.getOrDefault(s.charAt(i),0L)+cost[i]));
            total+=cost[i];
        }
        if(map.size()==1) return 0;
        long min=Long.MAX_VALUE;
        for(long val:map.values()){
            min=Math.min(min,total-val);
        }
        return min;
    }
}