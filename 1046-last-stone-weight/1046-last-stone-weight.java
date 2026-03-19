class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
          pq.offer(stones[i]);
        }
        int max1=pq.poll();
        while(!pq.isEmpty()){
            
            int max2=pq.poll();
            if(max2!=max1){
                int diff=Math.abs(max1-max2);
                pq.offer(diff);
                max1=pq.poll();
            }
            else{
                if(pq.isEmpty()) return 0;
                max1=pq.poll();
            }

        }
        return max1;
    }
}