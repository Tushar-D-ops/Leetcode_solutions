class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            int odd=func(s,i,i);
            int even=func(s,i,i+1);
            int max=Math.max(odd,even);
            if(max>maxlen){
                maxlen=max;
                start=i-((max-1)/2);
                end=i+max/2;
            }
        }
        return s.substring(start+1,end);
    }
    int func(String s,int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l+1;
    }
}