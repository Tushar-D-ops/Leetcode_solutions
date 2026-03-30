class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int even=0;
        int odd=0;
        if((s1.charAt(1)==s2.charAt(1) && s1.charAt(3)==s2.charAt(3)) || (s1.charAt(3)==s2.charAt(1) && s1.charAt(1)==s2.charAt(3))){
            odd=1;
        }
        if((s1.charAt(0)==s2.charAt(0) && s1.charAt(2)==s2.charAt(2)) || (s1.charAt(2)==s2.charAt(0) && s1.charAt(0)==s2.charAt(2))){
            even=1;
        }
        if(odd==1 && even==1) return true;
        return false;
    }
}