class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                  min=Math.min(min,Math.abs(i-map.get(nums[i])));
            }
            map.put(reverse(nums[i]),i);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    int reverse(int num){
        int n=0;
        while(num>0){
            int digit=num%10;
            n=n*10+digit;
            num=num/10;
        }
        return n;
    }
}