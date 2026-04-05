class Solution {
    public int[] minDifference(int n, int k) {
        ArrayList<Integer> best=new ArrayList<>();
        func(n,k,new ArrayList<>(),best,1);
        int ans[]=new int[best.size()];
        for(int i=0;i<best.size();i++){
           ans[i]=best.get(i);
        }
        return ans;
    }
    void func(int n,int k,ArrayList<Integer> curr,ArrayList<Integer> best,int start){
        if(k==0){
            if(n==1){
          int max=Collections.max(curr);
          int min=Collections.min(curr);
          int d1=max-min;
          if(best.isEmpty() || d1<Collections.max(best)-Collections.min(best)){
            best.clear();
            best.addAll(curr);
            }
            }
            return;
        }
        else{
           for(int i=start;i<=n;i++){
            if(n%i==0){
                curr.add(i);
                func(n/i,k-1,curr,best,i);
                curr.remove(curr.size()-1);
            }
           }
        }

    }
}