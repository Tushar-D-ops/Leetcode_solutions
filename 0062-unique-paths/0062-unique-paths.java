class Solution {
    public int uniquePaths(int m, int n) {
        int dp[]=new int[n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return func(m-1,n-1,dp);
        // for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[j]=1;
        for(int i=1;i<m;i++){
            int newdp[]=new int[n];
            newdp[0]=1;
            for(int j=1;j<n;j++){
                newdp[j]=dp[j]+newdp[j-1];
            }
            dp=newdp;
        }
        return dp[n-1];
    }
    int func(int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=func(i-1,j,dp)+func(i,j-1,dp);
    }
}