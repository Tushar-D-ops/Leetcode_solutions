class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int totalcols=grid[0].length;
        int totalrows=grid.length;
        int left=0;
        int right=totalcols-1;
        int up=0;
        int down=totalrows-1;
        int left1=0;
        int right1=totalcols-1;
        int up1=0;
        int down1=totalrows-1;
        while(left<right && up<down && left1<right1 && up1<down1){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=left;j<=right;j++){
             temp.add(grid[up][j]);
            }
            up++;
            for(int i=up;i<=down;i++){
                temp.add(grid[i][right]);
            }
            right--;
            for(int j=right;j>=left;j--){
                temp.add(grid[down][j]);
            }
            down--;
            for(int i=down;i>=up;i--){
                temp.add(grid[i][left]);
            }
            left++;
            int times=k%temp.size();
            temp=reverse(temp,0,times-1);
            temp=reverse(temp,times,temp.size()-1);
            temp=reverse(temp,0,temp.size()-1);
            int idx=0;
            for(int j=left1;j<=right1;j++){
             grid[up1][j]=temp.get(idx);
             idx++;
            }
            up1++;
            for(int i=up1;i<=down1;i++){
                grid[i][right1]=temp.get(idx);
                idx++;
            }
            right1--;
            for(int j=right1;j>=left1;j--){
                
                grid[down1][j]=temp.get(idx);
                idx++;
            }
            down1--;
            for(int i=down1;i>=up1;i--){
                
                grid[i][left1]=temp.get(idx);
                idx++;
            }
            left1++;
        }
        return grid;
    }
    ArrayList<Integer> reverse(ArrayList<Integer> list,int i,int j){
        while(i<j){
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        return list;
    }
}