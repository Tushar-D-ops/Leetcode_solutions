class Solution {
    public String countAndSay(int n) {
        
        return func(n);
    }
    String func(int n){
        if(n==1) return "1";
        String part=func(n-1);
        StringBuilder str=new StringBuilder();
        int i=0;
        while(i<part.length()){
            char curr=part.charAt(i);
            int cnt=0;
            while(i<part.length() && part.charAt(i)==curr){
               i++;
               cnt++;
            }
            str.append(cnt).append(curr);
        }
        return str.toString();
    }
}