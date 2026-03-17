class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        int res=0;
        for(int i=0;i<matrix.length;i++){
            Arrays.sort(matrix[i]);
            int start=matrix[i].length-1;
            for(int j=matrix[i].length-1;j>=0;j--){
                  
                  res=Math.max(res,matrix[i][j]*(start-j+1));
            }
        }
        return res;
    }
}