class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0;
        int left=0;
        int right=0;
        int sindex=-1;
        int endindex=-1;
        int maxsum=0;
        while(right<customers.length){
            if(grumpy[right]==1) sum+=customers[right];
            if(right-left+1>minutes){
                if(grumpy[left]==1) sum-=customers[left];
                left++;
            }
            if(right-left+1<=minutes){
               if(maxsum<sum){
                maxsum=sum;
                sindex=left;
                endindex=right;
               }
            }
            right++;
        }
        int ans=0;
        for(int i=0;i<customers.length;i++){
            if(sindex<=i && i<=endindex){
                ans+=customers[i];
            }
            else if(grumpy[i]==0) ans+=customers[i];
        }
        return ans;
    }
}