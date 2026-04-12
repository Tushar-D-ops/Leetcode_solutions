class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(prime(i)) l.add(i);
        }
        int mindiff=Integer.MAX_VALUE;
        int ans[]=new int[]{-1,-1};
        for(int i=0;i<l.size()-1;i++){
            int diff=l.get(i+1)-l.get(i);
            if(mindiff>diff){
                mindiff=diff;
                ans[0]=l.get(i);
                ans[1]=l.get(i+1);
            }
        }
        return ans;
    }
    boolean prime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}