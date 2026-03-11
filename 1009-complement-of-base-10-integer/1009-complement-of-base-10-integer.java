class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        StringBuilder s=new StringBuilder();
        for(char c:binary.toCharArray()){
            if(c=='0'){
                s.append("1");
            }
            else{
                s.append("0");
            }
        }
        return Integer.parseInt(s.toString(),2);
    }
}