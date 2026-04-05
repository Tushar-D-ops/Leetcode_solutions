class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> l=new ArrayList<>();
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int i=0;i<people.length;i++){
            int k=people[i][1];
            l.add(k,people[i]);
        }
        int[][] ans=new int[people.length][2];
        for(int i=0;i<people.length;i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}