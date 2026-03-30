class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int one=-1;
        int two=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                one=i;
            }
            else if (nums[i]==2) two=i;
            if(one!=-1 && two!=-1)min=Math.min(min,Math.abs(one-two));
            
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}