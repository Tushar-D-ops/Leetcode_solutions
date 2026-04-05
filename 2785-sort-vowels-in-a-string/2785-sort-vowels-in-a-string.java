class Solution {
    public String sortVowels(String s) {
        
        ArrayList<Character> l=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                l.add(c);
            }
        }
        Collections.sort(l);
        StringBuilder t=new StringBuilder();
        int idx=0;
        for(char c:s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                t.append(l.get(idx));
                idx++;
            }
            else{
             t.append(c);
            }
            
        }
        return t.toString();
    }
}