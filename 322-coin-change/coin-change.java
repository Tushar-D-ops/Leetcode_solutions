class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=func(coins,amount,dp,coins.length-1);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int func(int[] coins,int amount,int[][] dp,int idx){
        if(idx==0){
            if(amount%coins[idx]==0) return amount/coins[idx];
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int taken=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
         int res=func(coins,amount-coins[idx],dp,idx);
         if(res!=Integer.MAX_VALUE){
            taken=1+res;
         }
         
        }
        int nottaken=func(coins,amount,dp,idx-1);
        return dp[idx][amount]=Math.min(taken,nottaken);
    }
}