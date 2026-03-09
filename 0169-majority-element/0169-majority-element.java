class Solution {
    public int majorityElement(int[] nums) {
        int cnt=1;
        int majority=nums[0];
        int i=1;
        while(i<nums.length){
            if(cnt==0){
                majority=nums[i];
                cnt=1;
            }
            else if(nums[i]==majority) cnt++;
            else{
                cnt--;
                
            }
            i++;
        }
        if(cnt==0) return -1;
        return majority;
    }
}