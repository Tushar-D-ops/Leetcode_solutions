class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int visited[]=new int[graph.length];
        int pathvisited[]=new int[graph.length];
        HashSet<Integer> temp=new HashSet<>();
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                
                
                func(i,graph,pathvisited,visited,temp);
                      
                
            }
        }
        List<Integer> list=new ArrayList<>(temp);
        Collections.sort(list);
        return list;

    }
    boolean func(int node,int[][] graph,int[] pathvisited,int[] visited,HashSet<Integer> temp){
        visited[node]=1;
        pathvisited[node]=1;
        for(int i:graph[node]){
            if(visited[i]==0){
                 if(func(i,graph,pathvisited,visited,temp)) return true;
            }
            else if(pathvisited[i]==1) return true;
            
        }
        temp.add(node);
        pathvisited[node]=0;
        return false;    
        }
}