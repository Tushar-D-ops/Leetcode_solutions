class Solution {
    public String longestWord(String[] words) {
        HashSet<String> s=new HashSet<>();
        for(String word:words) s.add(word);
        String ans="";
        for(String word:words){
            boolean valid=true;
            for(int i=1;i<word.length();i++){
                if(!s.contains(word.substring(0,i))){
                    valid=false;
                    break;
                }
            }
            if(valid){
                if(word.length()>ans.length() || (word.length()==ans.length() && word.compareTo(ans) <0)){
                    ans=word;
                }
            }
        }
        return ans;
    }
}