class Solution {
    public int countSubstrings(String s) {
        int cnt=0;
        for(int i=0;i<s.length();i++){
            int odd=func(s,i,i);
            cnt+=odd;
            if(i<s.length()-1) cnt+=func(s,i,i+1);
        }
        return cnt;
    }
    int func(String s,int l,int r){
        int c=0;
        while(l>=0 & r<s.length() && s.charAt(l)==s.charAt(r)){
            c++;
            l--;
            r++;
        }
        return c;
    }
}