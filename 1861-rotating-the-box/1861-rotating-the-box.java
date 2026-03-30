class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] ans=new char[n][m];
        for(int i=0;i<m;i++){
            int sos=n-1;
            int j=n-1;
            while(j>=0){
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    boxGrid[i][sos]='#';
                    
                    sos--;
                }
                else if(boxGrid[i][j]=='*'){
                    sos=j-1;
                }
                j--;
            }
            for(int k=0;k<n;k++){
            ans[k][m-i-1]=boxGrid[i][k];
            }
        }
        return ans;
    }
}