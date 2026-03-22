class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(compare(mat,target)) return true;
        for(int i=0;i<4;i++){
            
            mat=rotate(mat);
            if(compare(mat,target)) return true;
        }
        return false;
    }
    boolean compare(int[][] mat,int[][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j]!=target[i][j]) return false;
            }

        }
        return true;
    }
    int[][] rotate(int[][] arr){
        int[][] temp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                temp[arr.length-j-1][i]=arr[i][j];
            }
        }
        return temp;
    }
}