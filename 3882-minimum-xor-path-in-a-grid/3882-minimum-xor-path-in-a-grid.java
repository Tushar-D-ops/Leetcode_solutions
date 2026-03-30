class Solution {
    public int minCost(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        HashSet<Integer> dp[][]=new HashSet[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new HashSet<>();
            }
        }
        dp[0][0].add(grid[0][0]);
        HashSet<Integer> res=func(grid,m-1,n-1,dp);
        int ans=Integer.MAX_VALUE;
        for(int i:res) ans=Math.min(ans,i);
        return ans;
    }
    HashSet<Integer> func(int[][] grid, int i,int j, HashSet<Integer> dp[][]){
        if(i==0 && j==0) return dp[0][0];
        if(i<0 || j<0) return new HashSet<>();
        if(!dp[i][j].isEmpty()) return dp[i][j];
        HashSet<Integer> upper=func(grid,i-1,j,dp);
        HashSet<Integer> left=func(grid,i,j-1,dp);
        HashSet<Integer> curr=new HashSet<>();
        for(int x:upper){
            curr.add(grid[i][j]^x);
        }
        for(int x:left){
            curr.add(grid[i][j]^x);
        };
       return dp[i][j]=curr;
    }
}