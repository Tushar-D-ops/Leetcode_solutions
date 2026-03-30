class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<int[]>());
        for(int edge[]:edges){
            ArrayList<int[]> temp1=graph.get(edge[0]);
            ArrayList<int[]> temp2=graph.get(edge[1]);
            temp1.add(new int[]{edge[1],edge[2]});
            temp2.add(new int[]{edge[0],edge[2]});
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.offer(new int[]{i,0});
            int cost[]=new int[n];
            for(int j=0;j<n;j++) cost[j]=Integer.MAX_VALUE;
            cost[i]=0;
            while(!pq.isEmpty()){
                int[] curr=pq.poll();
                for(int[] temp:graph.get(curr[0])){

                int newdist=curr[1]+temp[1];
                if(cost[temp[0]]>newdist){
                    cost[temp[0]]=newdist;
                    pq.offer(new int[]{temp[0],newdist});
                }
                }
            }
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i!=j && cost[j]<=distanceThreshold){
                    cnt++;
                }
            }
            ans[i]=cnt;
        }
        int city=0;
        for(int i=1;i<n;i++){
            if(ans[i]<ans[city] || (ans[i]==ans[city] && i>city)){
              city=i;
            }
        }
        return city;
    }
}