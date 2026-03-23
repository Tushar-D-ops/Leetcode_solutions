class Solution {

    int MOD = 1_000_000_007;
    Long[][][] dp;

    public int maxProductPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new Long[m][n][2];

        long[] res = solve(grid, m-1, n-1);

        long ans = res[1];

        if(ans < 0) return -1;

        return (int)(ans % MOD);
    }

    private long[] solve(int[][] grid, int i, int j){

        if(i == 0 && j == 0)
            return new long[]{grid[0][0], grid[0][0]};

        if(dp[i][j][0] != null)
            return new long[]{dp[i][j][0], dp[i][j][1]};

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        long val = grid[i][j];

        // from top
        if(i > 0){
            long[] up = solve(grid, i-1, j);

            min = Math.min(min, Math.min(val * up[0], val * up[1]));
            max = Math.max(max, Math.max(val * up[0], val * up[1]));
        }

        // from left
        if(j > 0){
            long[] left = solve(grid, i, j-1);

            min = Math.min(min, Math.min(val * left[0], val * left[1]));
            max = Math.max(max, Math.max(val * left[0], val * left[1]));
        }

        dp[i][j][0] = min;
        dp[i][j][1] = max;

        return new long[]{min, max};
    }
}