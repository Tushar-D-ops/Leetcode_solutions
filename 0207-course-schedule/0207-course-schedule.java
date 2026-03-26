class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int visited[]=new int[numCourses];
       
       Map<Integer,ArrayList<Integer>> map=new HashMap<>();
       for(int[] curr:prerequisites){
        ArrayList<Integer> temp=map.getOrDefault(curr[0],new ArrayList<>());
        temp.add(curr[1]);
        map.put(curr[0],temp);
       }
       for(int i=0;i<numCourses;i++){
        int pathvisited[]=new int[numCourses];
        if(visited[i]==0){
            if(func(map,i,visited,pathvisited)) return false;
        }
       }
       return true;
    }
    boolean func(Map<Integer,ArrayList<Integer>> map,int node,int[] visited,int[] pathvisited){
        visited[node]=1;
        pathvisited[node]=1;
        
        for(int curr:map.getOrDefault(node,new ArrayList<>())){
            if(visited[curr]==0){
                if(func(map,curr,visited,pathvisited)) return true;
            }
            else if(pathvisited[curr]==1) return true;
        }
        pathvisited[node]=0;
        return false;
    }
}