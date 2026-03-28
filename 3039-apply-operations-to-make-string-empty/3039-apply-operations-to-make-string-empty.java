class Solution {
    public String lastNonEmptyString(String s) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<26;i++) list.add(new ArrayList<>());
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            list.get(c-'a').add(i);
        }
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,list.get(i).size());
        }
        StringBuilder str=new StringBuilder();
        ArrayList<Integer> indices=new ArrayList<>();
        for(int i=0;i<26;i++){
            ArrayList<Integer> temp=list.get(i);
            if(max==temp.size()){
                indices.add(temp.get(temp.size()-1));
            }
        }
        Collections.sort(indices);
        for(int i:indices) str.append(s.charAt(i));
        return str.toString();
    }
}