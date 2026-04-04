class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<queens.length;i++){

            int[] curr = queens[i];

            int newkingx = king[0]-curr[0];
            int newkingy = king[1]-curr[1];

            if(curr[0]==king[0] ||
               curr[1]==king[1] ||
               Math.abs(newkingx)==Math.abs(newkingy)){

                boolean found=false;

                for(int j=0;j<queens.length;j++){

                    if(i==j) continue;

                    int[] temp=queens[j];

                    int newqueenx=temp[0]-curr[0];
                    int newqueeny=temp[1]-curr[1];

                    boolean sameLine =
                        (curr[0]==king[0] && temp[0]==curr[0]) ||
                        (curr[1]==king[1] && temp[1]==curr[1]) ||
                        (Math.abs(newqueenx)==Math.abs(newqueeny));

                    boolean sameDirection =
                        Integer.signum(newqueenx)==Integer.signum(newkingx) &&
                        Integer.signum(newqueeny)==Integer.signum(newkingy);

                    boolean closer =
                        Math.max(Math.abs(newqueenx), Math.abs(newqueeny)) <
                        Math.max(Math.abs(newkingx), Math.abs(newkingy));

                    if(sameLine && sameDirection && closer){
                        found=true;
                        break;
                    }
                }

                if(!found){
                    ans.add(Arrays.asList(curr[0], curr[1]));
                }
            }
        }

        return ans;
    }
}