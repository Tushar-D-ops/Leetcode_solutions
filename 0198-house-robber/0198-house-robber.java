class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        // Arrays.fill(dp,-1);
        // return func(nums,nums.length-1,dp);
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int prev1=nums[0];
        int prev2=Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++){
        int max=Math.max(prev2,nums[i]+prev1);
            prev1=prev2;
            prev2=max;
        }
        return prev2;
    }
    int func(int[] nums,int i,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=Math.max(nums[i]+func(nums,i-2,dp),func(nums,i-1,dp));
        return dp[i];
    }
}