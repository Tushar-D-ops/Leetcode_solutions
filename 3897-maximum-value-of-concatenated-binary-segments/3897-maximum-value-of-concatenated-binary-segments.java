class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        ArrayList<String> segments=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            int ones=nums1[i];
            int zeroes=nums0[i];
            int n=0;
            StringBuilder temp=new StringBuilder();
            for(int k=0;k<ones;k++){
                temp.append("1");
            }
            for(int k=0;k<zeroes;k++){
                temp.append("0");
            }
            segments.add(temp.toString());
        }
        Collections.sort(segments,(a,b)-> (b+a).compareTo(a+b) );
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nums1.length;i++){
            str.append(segments.get(i));
        }
        String s=str.toString();
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans=(ans*2 +s.charAt(i)-'0')%1_000_000_007;
        }
        return ans;
    }
}