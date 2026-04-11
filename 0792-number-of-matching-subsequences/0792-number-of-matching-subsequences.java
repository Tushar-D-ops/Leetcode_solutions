class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int cnt=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(String t:map.keySet()){
            if(func(t,s)) cnt+=map.get(t);
        }
        return cnt;
    }
    boolean func(String t,String s){
        int i=0;
        int j=0;
        while(i<s.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                if(j==t.length()) break;
            }
            else{
                i++;
            }

        }
        if(i==s.length() && j<t.length()){
           return false;
        }
        return true;

    }
}