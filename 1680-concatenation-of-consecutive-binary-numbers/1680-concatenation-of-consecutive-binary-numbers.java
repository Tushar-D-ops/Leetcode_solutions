class Solution {
    public int concatenatedBinary(int n) {

        StringBuilder s = new StringBuilder();

        for(int i=1;i<=n;i++){
            s.append(Integer.toBinaryString(i));
        }

        String str = s.toString();   // convert once

        long ans = 0;
        int mod = 1_000_000_007;

        for(int i=0;i<str.length();i++){

            ans = (ans*2 + (str.charAt(i)-'0')) % mod;
        }

        return (int) ans;
    }
}