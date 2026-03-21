class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int colend=y+k-1;
        int rowend=x+k-1;
        while(x<rowend){
            int temp[]=new int[k];
            for(int i=y;i<=colend;i++){
                temp[i-y]=grid[x][i];
                }
            for(int i=y;i<=colend;i++){
                grid[x][i]=grid[rowend][i];
                }
            for(int i=y;i<=colend;i++){
                grid[rowend][i]=temp[i-y];
                }
                x++;
                rowend--;       
        }
        return grid;
    }
}