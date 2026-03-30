class Solution {
    int MOD=1_000_000_007;
    long[] fact;
    public int countVisiblePeople(int n, int pos, int k) {
        int lefties=pos;
        int righties=n-pos-1;
        long ans=0;
        fact=new long[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i]=(fact[i-1]*i)%MOD;
        }
        for(int x=0;x<=k;x++){
            int y=k-x;
            if(x<=lefties && y<=righties){
                long ways=(nCr(lefties,x)*nCr(righties,y))%MOD;
                ans=(ans+ways)%MOD;
            }
            
        }
        ans=(ans*2)%MOD;
        return (int)ans;}
 long nCr(int N,int r){
        if(r<0 || r>N) return 0;
        long numerator=fact[N];
     long denominator=(fact[N-r]*fact[r])%MOD;
        return (numerator*power(denominator,MOD-2))%MOD;
    }
    long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}