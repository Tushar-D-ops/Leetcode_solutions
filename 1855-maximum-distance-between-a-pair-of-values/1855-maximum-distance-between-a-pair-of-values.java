class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]) j++;
            else i++;
            max=Math.max(max,j-1-i);
        }
        return max;
    }
}