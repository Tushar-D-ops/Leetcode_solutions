class Solution {
    public int minSwaps(int[] nums) {
        int cnt1=0;
        for(int i=0;i<nums.length;i++) if(nums[i]==1) cnt1++;
        int i=0;
        int passes=0;
        int left=0;
        int right=0;
        int cnt0=0;
        while(right<cnt1){
            if(nums[right]==0) cnt0++;
            right++;
        }
        int min=cnt0;
        while(right<nums.length*2){
            if(nums[(right)%nums.length]==0) cnt0++;
          if(nums[left%nums.length]==0) cnt0--;
          left++;

          min=Math.min(min,cnt0);
          right++;
        }
        return min;
    }
}