class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> s=map.getOrDefault(nums[i],new ArrayList<>());
            s.add(i);
            map.put(nums[i],s);
        }
        long[] ans=new long[nums.length];
        for(int i:map.keySet()){
            ArrayList<Integer> temp=map.get(i);
            long prefix[]=new long[temp.size()];
            for(int j=0;j<temp.size();j++){
                prefix[j]=j==0?temp.get(0):prefix[j-1]+temp.get(j);
                
            }
            for(int j=0;j<temp.size();j++){
            long left=j==0?0:(long)temp.get(j)*j-prefix[j-1];
            long right=(prefix[temp.size()-1]-prefix[j])-((long)(temp.size()-j-1)*temp.get(j));
            ans[temp.get(j)]=left+right;
            }
            
        }
        return ans;
    }
}