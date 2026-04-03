class Solution {
    public int numberOfPairs(int[][] points) {
        int cnt=0;
        for(int i=0;i<points.length;i++){
            int[] curr=points[i];
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int curr2[]=points[j];
                if(curr2[0]<=curr[0] && curr2[1]>=curr[1]){
                    boolean check=true;
                    for(int k=0;k<points.length;k++){
                        if(k==i || k==j) continue;
                        int[] temp=points[k];
                        if(temp[0]<=curr[0] && temp[0]>=curr2[0] && temp[1]>=curr[1] && temp[1]<=curr2[1]){
                            check=false;
                            break;
                        }
                        
                    }
                    if(check) cnt++;
                }
            }
        }
        return cnt;
    }
}