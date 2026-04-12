class Solution {
    HashMap<Integer,int[]> map;
    public int minimumDistance(String word) {
        map=new HashMap<>();
        int cnt=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                // ArrayList<Integer> temp=new ArrayList<>();
                // temp.add(i);
                // temp.add(j);
                map.put(cnt,new int[]{i,j});
                cnt++;
            }
        }
        
        map.put(24,new int[]{4,0});
        map.put(25,new int[]{4,1});
        
        int dp[][][]=new int[word.length()][27][27];
        for(int i=0;i<word.length();i++){
            for(int j=0;j<27;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(word,0,26,26,dp);
    }
    int func(String word,int i,int f1,int f2,int[][][] dp){
      if(i>=word.length()) return 0;
      if(dp[i][f1][f2]!=-1) return dp[i][f1][f2];
      int[] curr=map.get(word.charAt(i)-'A');
      int cost1=0;
      int cost2=0;
      if(f1==26){
           cost1=0+func(word,i+1,word.charAt(i)-'A',f2,dp);
      }
      else{
           int temp[]=map.get(f1);
           cost1=Math.abs(temp[0]-curr[0])+Math.abs(temp[1]-curr[1])+func(word,i+1,word.charAt(i)-'A',f2,dp);
      }
      if(f2==26){
           cost2=0+func(word,i+1,f1,word.charAt(i)-'A',dp);
      }
      else{
           int temp[]=map.get(f2);
           cost2=Math.abs(temp[0]-curr[0])+Math.abs(temp[1]-curr[1])+func(word,i+1,f1,word.charAt(i)-'A',dp);
      }
      return dp[i][f1][f2]=Math.min(cost1,cost2);
    }
}