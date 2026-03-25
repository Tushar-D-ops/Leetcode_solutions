class Solution {
    public int arrayNesting(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> s=new HashSet<>();
            max=Math.max(max,func(nums,i,dp,s));
        }
        return max;
    }
    int func(int[] nums,int i,int dp[],HashSet<Integer> s){
        if(s.contains(nums[i])){
            return s.size();
        }
        if(dp[i]!=-1) return dp[i];
        s.add(nums[i]);
        return dp[i]=func(nums,nums[i],dp,s);
    }
}