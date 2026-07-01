class Solution {
    public boolean validPalindrome(String s) {

        boolean m=true,n=true;
        int del=0;
        int i=0, j=s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else if(del<=0){
                i++;
                del=1;
            }
            else{
                m=false;
                break;
            }
        }
        i=0;j=s.length()-1; del=0;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else if(del<=0){
                j--;
                del=1;
            }
            else{
                n=false;
                break;
            }
        }
        return n||m;

        
    }

   
}