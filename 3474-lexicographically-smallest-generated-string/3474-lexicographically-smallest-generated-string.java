class Solution {
    public String generateString(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int size=n+m-1;
        int free[]=new int[size];
        char ans[]=new char[size];
        Arrays.fill(ans,'?');
        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                for(int j=i;j<i+m;j++){
                    if(ans[j]!='?' && ans[j]!=str2.charAt(j-i)) return "";
                    ans[j]=str2.charAt(j-i);
                    free[j]=1;
                }
            }
        }
        for(int i=0;i<size;i++){
            if(ans[i]=='?'){
                ans[i]='a';
            }
        }
        for(int i=0;i<n;i++){
          if(str1.charAt(i)=='F' && matches(i,ans,str2)){
              int changeindex=-1;
              for(int j=i;j<i+m;j++){
                if(free[j]==0){
                    changeindex=j;
                }
              }
              if(changeindex == -1)
                    return "";

                ans[changeindex] = 'b';
                free[changeindex] =1;
          }
        }
        return new String(ans);
    }
    boolean matches(int start,char[] ans,String str2){
        for(int i=0;i<str2.length();i++){
            if(ans[i+start]!=str2.charAt(i)) return false;
        }
        return true;
    }
}