class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean allzero=true;
        for(int i:nums){
            xor=xor^i;
            if(i!=0) allzero=false;
        }
        if(allzero) return 0;
        if(xor!=0) return nums.length;
        return nums.length-1;
    }
}