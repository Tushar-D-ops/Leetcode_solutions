class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int [][] board=new int[8][8];
        List<List<Integer>> ans=new ArrayList<>();
        for(int curr[]:queens){
            board[curr[0]][curr[1]]=1;
        }
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int d[]:dir){
            int kingx=king[0];
            int kingy=king[1];
            while(true){
                if(kingx<0 || kingy<0 || kingx>7 || kingy>7) break;
                if(board[kingx][kingy]==1){
                    List<Integer> l=new ArrayList<>();
                    l.add(kingx);
                    l.add(kingy);
                    ans.add(l);
                    break;
                }
                kingx+=d[0];
                kingy+=d[1];
            }
        }
        return ans;
    }
}