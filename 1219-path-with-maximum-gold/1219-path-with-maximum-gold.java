class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int max=0;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    int [][] visited=new int[m][n];
                    max=Math.max(max,func(grid,i,j,visited,dir));
                }
            }
        }
        return max;
    }
    int func(int[][] grid,int i,int j,int[][] visited,int[][] dir){
        int maxi=0;
        visited[i][j]=1;
        for(int d[]:dir){
            int newi=d[0]+i;
            int newj=d[1]+j;
            if(newi>=0 && newi<grid.length && newj>=0 && newj<grid[0].length && grid[newi][newj]!=0 && visited[newi][newj]!=1){
              maxi=Math.max(maxi,func(grid,newi,newj,visited,dir));
            }
        }
        visited[i][j]=0;
        return maxi+=grid[i][j];
    }
}