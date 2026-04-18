class Solution {
    public int mirrorDistance(int n) {
        int a=n;
        int res=0;
        while(a>0){
            int digit=a%10;
            res=res*10+digit;
            a=a/10;
        }
        return Math.abs(n-res);
    }
}