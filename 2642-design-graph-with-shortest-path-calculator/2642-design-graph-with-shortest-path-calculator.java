class Graph {
     ArrayList<ArrayList<int[]>> graph;
    public Graph(int n, int[][] edges) {
        graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<int[]>());
        for(int edge[]:edges){
            ArrayList<int[]> temp=graph.get(edge[0]);
            temp.add(new int[]{edge[1],edge[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{node1,0});
        int visited[]=new int[graph.size()];
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[0]==node2) return curr[1];
            if(visited[curr[0]]==1) continue;
            visited[curr[0]]=1;
            for(int nei[]:graph.get(curr[0])){
                if(visited[nei[0]]==0){
                    pq.offer(new int[]{nei[0],nei[1]+curr[1]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */