class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            int curr[] = queens[i];
            int newkingx = king[0] - curr[0];
            int newkingy = king[1] - curr[1];
            if (curr[0] == king[0] || curr[1] == king[1] || Math.abs(newkingx) == Math.abs(newkingy)) {
                boolean found = false;
                for (int j = 0; j < queens.length; j++) {
                    int temp[] = queens[j];
                    int newqueenx = temp[0] - curr[0];
                    int newqueeny = temp[1] - curr[1];
                    if ((curr[0] == temp[0] && curr[0] == king[0]) ||
                            (curr[1] == temp[1] && curr[1] == king[1]) ||
                            Math.abs(newqueenx) == Math.abs(newqueeny)) {

                        if (((newkingx > 0 && newqueenx > 0 && newkingy > 0 && newqueeny > 0)
                                || (newkingx > 0 && newqueenx > 0 && newkingy < 0 && newqueeny < 0)
                                || (newkingx < 0 && newqueenx < 0 && newkingy > 0 && newqueeny > 0)
                                || (newkingx < 0 && newqueenx < 0 && newkingy < 0 && newqueeny < 0)
                                || (newkingx == 0 && newqueenx == 0 && newkingy > 0 && newqueeny > 0)
                                || (newkingx == 0 && newqueenx == 0 && newkingy < 0 && newqueeny < 0)
                                || (newkingx > 0 && newqueenx > 0 && newkingy == 0 && newqueeny == 0)
                                || (newkingx < 0 && newqueenx < 0 && newkingy == 0 && newqueeny == 0))
                                && Math.max(Math.abs(newqueenx),Math.abs(newqueeny)) < 
                                Math.max(Math.abs(newkingx),Math.abs(newkingy))) {
                            found = true;
                            break;
                        }
                    }
                }
                if(!found){
                    List<Integer> l=new ArrayList<>();
                    l.add(curr[0]);
                    l.add(curr[1]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}