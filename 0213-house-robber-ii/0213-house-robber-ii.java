class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==0) return 0;
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int prev1=nums[0];
        int prev2=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            int max=Math.max(prev2,prev1+nums[i]);
            prev1=prev2;
            prev2=max;
            
        }
        int prev3=nums[1];
        int prev4=Math.max(nums[2],nums[1]);
        for(int i=3;i<nums.length;i++){
            int max=Math.max(prev4,prev3+nums[i]);
            prev3=prev4;
            prev4=max;
        }
        return Math.max(prev2,prev4);
    }
}