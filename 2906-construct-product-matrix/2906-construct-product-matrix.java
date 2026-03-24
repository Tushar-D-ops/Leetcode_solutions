class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] p = new int[m][n];
        int[][] s = new int[m][n];

        long prefix = 1;
        long suffix = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                // prefix from top-left
                p[i][j] =(int) prefix;
                prefix = (prefix * grid[i][j]) % 12345;
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                s[i][j]=(int)suffix;
                suffix=(suffix*grid[i][j])%12345;
            }
        }

        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = (p[i][j] * s[i][j]) % 12345;
            }
        }

        return res;
    }
}