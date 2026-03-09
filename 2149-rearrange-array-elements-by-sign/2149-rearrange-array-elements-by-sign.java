class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i:nums){
            if(i>0){
                pos.add(i);
            }
            else neg.add(i);
        }
        int idx=0;
        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                nums[idx]=pos.get(i);
                idx++;
                nums[idx]=neg.get(i);
                idx++;
            }
            for(int i=neg.size();i<pos.size();i++){
                nums[idx]=pos.get(i);
                idx++;
            }
        }
        else{
            for(int i=0;i<pos.size();i++){
                nums[idx]=pos.get(i);
                idx++;
                nums[idx]=neg.get(i);
                idx++;
            }
            for(int i=pos.size();i<neg.size();i++){
                nums[idx]=neg.get(i);
                idx++;
            }
        }
        return nums;
    }
}