class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length+1];
        for(int curr[]:queries){
            diff[curr[0]]++;
            if(curr[1]+1<nums.length){
               diff[curr[1]+1]--;
            }
        }
        int op=0;
        for(int i=0;i<nums.length;i++){
            diff[i+1]=diff[i]+diff[i+1];
            if(nums[i]>diff[i]) return false;
        }
        return true;
    }
}