class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        ArrayList<ArrayList<Pair<Integer,Integer>>> matrix=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            ArrayList<Pair<Integer,Integer>> temp=new ArrayList<>();
            if(grid[i][0]=='X'){
              temp.add(new Pair<>(1,0));
            }
            else if(grid[i][0]=='Y'){
                temp.add(new Pair<>(0,1));
            }
            else{
                temp.add(new Pair<>(0,0));
            }
            
            for(int j=1;j<grid[i].length;j++){
                
                    Pair<Integer,Integer> prev=temp.get(temp.size()-1);
                    if(grid[i][j]=='X'){
                    temp.add(new Pair<>(prev.getKey()+1,prev.getValue()));
                    
                }
                else if(grid[i][j]=='Y'){
                    temp.add(new Pair<>(prev.getKey(),prev.getValue()+1));
                    
                }
                else{
                       temp.add(new Pair<>(prev.getKey(),prev.getValue()));
                }
            }
            matrix.add(temp);
        }
        int cnt=0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                Pair<Integer,Integer> curr=matrix.get(i).get(j);
                Pair<Integer,Integer> upper=new Pair<>(0,0);
                if(i>0) upper=matrix.get(i-1).get(j);
                int totalx=curr.getKey()+upper.getKey();
                int totaly=curr.getValue()+upper.getValue();
                if(totalx>0 && totalx==totaly) cnt++;
                ArrayList<Pair<Integer,Integer>> temp=matrix.get(i);
                temp.set(j,new Pair<>(totalx,totaly));

            }
        }
        return cnt;
    }
}