class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int edge[]:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> r=new HashSet<>();
        for(int i:restricted) r.add(i);
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int cnt=0;
        int[] visited=new int[n];
        while(!q.isEmpty()){
            int curr=q.poll();
            if(visited[curr]==1) continue;
            visited[curr]=1;
            cnt++;
            for(int nei:graph.get(curr)){
                if(visited[nei]==0 && !r.contains(nei)){
                    q.offer(nei);
                    
                }
            }
        }
        return cnt;
    }
}