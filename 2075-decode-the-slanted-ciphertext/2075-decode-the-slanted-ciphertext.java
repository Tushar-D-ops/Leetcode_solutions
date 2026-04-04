class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols=encodedText.length()/rows;
        char arr[][]=new char[rows][cols];
        int idx=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
            arr[i][j]=encodedText.charAt(idx);
            idx++;
            }
        }
        StringBuilder s=new StringBuilder();
        for(int k=0;k<cols;k++){
            int i=0;
            int j=k;
            while(i<rows && j<cols){
                s.append(arr[i][j]);
                i++;
                j++;
            }
        }
        return s.toString().stripTrailing();
    }
}