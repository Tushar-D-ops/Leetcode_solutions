class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int ans=0;
        while(right<s.length()){
            char curr=s.charAt(right);
            if(map.containsKey(curr)){
                left=Math.max(left,map.get(curr)+1);
            }
            map.put(curr,right);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}