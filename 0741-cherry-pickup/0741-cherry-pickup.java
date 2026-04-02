class Solution {

    Integer[][][] dp;
    int n;

    public int cherryPickup(int[][] grid) {

        n = grid.length;
        dp = new Integer[n][n][n];

        int ans = solve(grid,0,0,0);

        return Math.max(ans,0);
    }

    int solve(int[][] grid,int r1,int c1,int r2){

        int c2 = r1 + c1 - r2;

        if(r1>=n || c1>=n || r2>=n || c2>=n)
            return Integer.MIN_VALUE;

        if(grid[r1][c1]==-1 || grid[r2][c2]==-1)
            return Integer.MIN_VALUE;

        if(r1==n-1 && c1==n-1)
            return grid[r1][c1];

        if(dp[r1][c1][r2]!=null)
            return dp[r1][c1][r2];

        int cherries = 0;

        if(r1==r2 && c1==c2)
            cherries = grid[r1][c1];
        else
            cherries = grid[r1][c1] + grid[r2][c2];

        int best = Math.max(
                    Math.max(
                        solve(grid,r1+1,c1,r2+1),
                        solve(grid,r1,c1+1,r2)
                    ),
                    Math.max(
                        solve(grid,r1+1,c1,r2),
                        solve(grid,r1,c1+1,r2+1)
                    )
                );

        cherries += best;

        return dp[r1][c1][r2] = cherries;
    }
}