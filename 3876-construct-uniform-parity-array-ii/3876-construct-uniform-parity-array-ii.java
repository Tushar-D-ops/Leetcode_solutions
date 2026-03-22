class Solution {
    public boolean uniformArray(int[] nums1) {
        int minodd=Integer.MAX_VALUE;
        int mineven=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                mineven=Math.min(mineven,nums1[i]);
            }
            else{
                minodd=Math.min(minodd,nums1[i]);
            }
        }
        if(minodd==Integer.MAX_VALUE || mineven==Integer.MAX_VALUE){
            return true;
        }
        if(minodd<mineven) return true;
        return false;
    }
}