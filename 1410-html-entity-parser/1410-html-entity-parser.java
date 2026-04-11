class Solution {
    public String entityParser(String text) {
        StringBuilder str=new StringBuilder();
        int i=0;
        int n=text.length();
        while(i<n){
            if(text.charAt(i)!='&'){
                str.append(text.charAt(i));
                i++;
                continue;
            }
            if(i+6 <=n && text.substring(i,i+6).equals("&quot;")){
                str.append("\"");
                i=i+6;
            }
            else if(i+6 <=n && text.substring(i,i+6).equals("&apos;")){
                str.append("\'");
                i=i+6;
            }
            else if(i+5 <=n && text.substring(i,i+5).equals("&amp;")){
                str.append("&");
                i=i+5;
            }else if(i+4 <=n && text.substring(i,i+4).equals("&gt;")){
                str.append(">");
                i=i+4;
            }else if(i+4 <=n && text.substring(i,i+4).equals("&lt;")){
                str.append("<");
                i=i+4;
            }
            else if(i+7 <=n && text.substring(i,i+7).equals("&frasl;")){
                str.append("/");
                i=i+7;
            }
            else{
                str.append(text.charAt(i));
                i++;
            }
        }
        return str.toString();
    }
}