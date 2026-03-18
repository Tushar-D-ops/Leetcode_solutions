class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        if(grid[0][0]>k) return 0;
        int cnt=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(j!=0){
                  grid[i][j]+=grid[i][j-1];
                }
               
                    
                
            }
            
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0 && j==0) continue;
                if(i==0){
                    if(grid[i][j]<=k){
                    cnt++;
                }
                }
                else{
                 grid[i][j]+=grid[i-1][j];
                if(grid[i][j]<=k) cnt++;
                }
                
                
            }
        }
       
        
        return cnt;

    }
}