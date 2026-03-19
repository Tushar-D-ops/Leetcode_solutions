class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double,int[]>> pq= new PriorityQueue<>((a,b)->Double.compare(a.getKey(),b.getKey()));
        for(int i=0;i<points.length;i++){
                pq.offer(new Pair<>(Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]),points[i]));
            
        }
        int[][] ans=new int[k][2];
        while(k>0){
            ans[k-1]=pq.poll().getValue();
            k--;
        }
        return ans;
    }
}