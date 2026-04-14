class Solution {
    public int maxWeight(int n, int[][] edges, int k, int t) {
        int ans=-1;
        if(k==0){
            if(t<0) return -1;
            return 0;
        }
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<int[]>());
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
        }
        HashSet<Integer> dp[][]=new HashSet[n][k+1];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
              dp[i][j]=new HashSet<>();
            }
            
        }
        for(int i=0;i<n;i++){
            q.offer(new int[]{i,0,0});
            dp[i][0].add(0);

        }
        while(!q.isEmpty()){
         int curr[]=q.poll();
         if(curr[2]==k){
            ans=Math.max(ans,curr[1]);
            continue;
         }
         for(int nei[]:list.get(curr[0])){
            int newweight=nei[1]+curr[1];
            if(newweight<t){
            if(!dp[nei[0]][curr[2]+1].contains(newweight)){
                dp[nei[0]][curr[2]+1].add(newweight);
                q.offer(new int[]{nei[0],newweight,curr[2]+1});
            }
         }
         }
        }
        return ans;
    }
}