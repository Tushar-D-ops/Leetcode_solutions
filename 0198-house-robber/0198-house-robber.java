class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return func(nums,nums.length-1,dp);
    }
    int func(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=Math.max(nums[i]+func(nums,i-2,dp),func(nums,i-1,dp));
        return dp[i];
    }
}