class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder s=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i)=='0'){
                s.append('1');
            }
            else{
                s.append('0');
            }
        }
        return s.toString();
    }
}