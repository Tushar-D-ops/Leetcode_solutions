class Solution {
    int MOD=1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair<Integer,Integer>>> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<Pair<Integer,Integer>>());
        for(int[] road:roads){
            list.get(road[0]).add(new Pair<>(road[1],road[2]));
            list.get(road[1]).add(new Pair<>(road[0],road[2]));
        }
        long dist[]=new long[n];
        int ways[]=new int[n];
        dist[0]=0;
        for(int i=1;i<n;i++) dist[i]=Long.MAX_VALUE;
        ways[0]=1;
        PriorityQueue<Pair<Integer,Long>> pq=new PriorityQueue<>((a,b)->Long.compare(a.getValue(), b.getValue()));
        pq.offer(new Pair<>(0,0L));
        while(!pq.isEmpty()){
            Pair<Integer,Long> curr=pq.poll();
            for(Pair<Integer,Integer> next:list.get(curr.getKey())){
                long newdist=(curr.getValue()+next.getValue());
                if(newdist<dist[next.getKey()]){
                    dist[next.getKey()]=newdist;
                    ways[next.getKey()]=ways[curr.getKey()];
                    pq.offer(new Pair<>(next.getKey(),newdist));
                }
                else if(newdist==dist[next.getKey()]) ways[next.getKey()]=(ways[next.getKey()]+ways[curr.getKey()])%MOD;
            }
        }
        return ways[n-1];
    }
}