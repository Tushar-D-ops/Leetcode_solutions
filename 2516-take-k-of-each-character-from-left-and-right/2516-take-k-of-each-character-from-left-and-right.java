class Solution {
    public int takeCharacters(String s, int k) {
        int hash[]=new int[3];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        for(int i=0;i<3;i++) if(hash[i]<k) return -1;
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        while(right<s.length()){
            char curr=s.charAt(right);
            hash[curr-'a']--;
            while(hash[curr-'a']<k){
                hash[s.charAt(left)-'a']++;
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return s.length()-max;
    }
}