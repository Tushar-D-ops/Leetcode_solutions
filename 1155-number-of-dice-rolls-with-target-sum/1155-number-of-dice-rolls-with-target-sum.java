class Solution {
    int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(n,k,target,dp);
    }
    int func(int n,int k,int target,int[][] dp){
        if(target==0 && n==0)return 1;
        if(target==0 || n==0) return 0;
           
        if(dp[n][target]!=-1) return dp[n][target];
        int ways=0;
        for(int i=1;i<=k;i++){
            if(target-i>=0){
                ways=(ways+func(n-1,k,target-i,dp))%(MOD);
            }
        }
        return dp[n][target]=ways;
    }
}