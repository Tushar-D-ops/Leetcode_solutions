class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans=Integer.MAX_VALUE;
        if(nums[start]==target) return 0;
        int i=start-1;
        int j=start+1;
        while(i>=0 || j<nums.length){
            if(i>=0){
                if(nums[i]==target){
                    ans=Math.abs(start-i);
                    break;
                }
                i--;
            }
            if(j<nums.length){
                if(nums[j]==target){
                    ans=Math.abs(start-j);
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}