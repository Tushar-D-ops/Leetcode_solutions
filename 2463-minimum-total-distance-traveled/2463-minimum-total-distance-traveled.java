class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n1=robot.size();
        int n2=factory.length;
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        
        
        long dp[][]=new long[n1][n2];
        for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        return func(robot,factory,n1-1,n2-1,dp);
    }
    long func(List<Integer> robot,int[][] factory,int r,int f,long[][] dp ){
        if(r<0) return 0;
        if(f<0) return (long)1e15;
        if(dp[r][f]!=-1) return dp[r][f];
        long min=Long.MAX_VALUE;
        long cost=0;
        long notpick=func(robot,factory,r,f-1,dp);
        for(int k=1;k<=factory[f][1] && r-k+1>=0;k++){
            cost+=Math.abs(robot.get(r-k+1)-factory[f][0]);
            min=Math.min(min,cost+func(robot,factory,r-k,f-1,dp));
        }
        return dp[r][f]=Math.min(min,notpick);
    }
}