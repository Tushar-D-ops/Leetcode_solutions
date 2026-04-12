class Solution {
    public long maxAlternatingSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        long[][] dp=new long[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(nums,0,0,dp);
    }
    long func(int[] nums,int i,int even,long[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][even]!=-1) return dp[i][even];
        long notpick=func(nums,i+1,even,dp);
        long pick=Long.MIN_VALUE;
        if(even==0){
            pick=nums[i]+func(nums,i+1,1,dp);
        }
        else{
            pick=-nums[i]+func(nums,i+1,0,dp);
        }
        return dp[i][even]=Math.max(pick,notpick);
    }
}