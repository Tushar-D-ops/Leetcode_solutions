class Solution {
    int MOD=1_000_000_007;
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Long[][][] dp=new Long[m][n][2];
        long res[]=func(grid,m-1,n-1,dp);
        if(res[1]<0) return -1;
        return (int)(res[1]%MOD);
    }
    long[] func(int[][] grid,int i,int j,Long[][][] dp){
        if(i==0 && j==0) return new long[]{grid[0][0],grid[0][0]};
        if(dp[i][j][0] != null)
            return new long[]{dp[i][j][0], dp[i][j][1]};
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        if(i>0){
            long[] up=func(grid,i-1,j,dp);
            min=Math.min(min,Math.min(grid[i][j]*up[0],grid[i][j]*up[1]));
            max=Math.max(max,Math.max(grid[i][j]*up[0],grid[i][j]*up[1]));
        }
        if(j>0){
            long[] left=func(grid,i,j-1,dp);
            min=Math.min(min,Math.min(grid[i][j]*left[0],grid[i][j]*left[1]));
            max=Math.max(max,Math.max(grid[i][j]*left[0],grid[i][j]*left[1]));
        }
        dp[i][j][0]=min;
        dp[i][j][1]=max;
        return new long[]{min,max};
    }
}