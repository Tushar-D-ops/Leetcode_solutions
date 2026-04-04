class Solution {
    public int longestMountain(int[] arr) {
        int max=0;
        for(int i=1;i<arr.length-1;i++){
            int left=i-1;
            int right=i+1;
            if(arr[left]<arr[i] && arr[right]<arr[i]){
            while(left>=0 && arr[left]<arr[left+1]) left--;
            while(right<arr.length && arr[right]<arr[right-1]) right++;
           max=Math.max(max,right-left+1-2);
            }
        }
        return max;
    }
}