class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
                  list.add(new ArrayList<Integer>());
        }
        for(int arr[]:prerequisites){
            list.get(arr[0]).add(arr[1]);
        }
        int visited[]=new int[numCourses];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                int[] pathvisited=new int[numCourses];
                if(func(i,visited,pathvisited,list,ans)) return new int[]{};
            }
        }
        int res[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    boolean func(int node,int[] visited,int[] pathvisited,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> ans){
      visited[node]=1;
      pathvisited[node]=1;
      for(int i:list.get(node)){
        if(visited[i]==0){
            if(func(i,visited,pathvisited,list,ans)) return true;
        }
        else if(pathvisited[i]==1) return true;
      }
      pathvisited[node]=0;
      ans.add(node);
      return false;
    }
}