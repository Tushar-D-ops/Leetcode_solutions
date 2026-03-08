class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> s=new HashSet<>();
        HashSet<String> processed=new HashSet<>();
        for(String i:nums) s.add(i);
        return func(nums,nums[0],s,processed);
    }
    String func(String nums[],String curr,HashSet<String> s,HashSet<String> processed){
        if(processed.contains(curr)) return null;
        processed.add(curr);
        for(int i=0;i<curr.length();i++){
            String newstring="";
            if(curr.charAt(i)=='0'){
                newstring=curr.substring(0,i)+"1"+curr.substring(i+1,curr.length());
            }
            else{
                newstring=curr.substring(0,i)+"0"+curr.substring(i+1,curr.length());

            }
            if(!s.contains(newstring)) return newstring;
            String returned=func(nums,newstring,s,processed);
            if(returned!=null) return returned;
        }
        return null;
    }
}