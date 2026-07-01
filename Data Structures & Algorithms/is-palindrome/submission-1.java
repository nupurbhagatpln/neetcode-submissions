class Solution {
    public boolean isPalindrome(String s) {
        String t=s;
       t= t.replaceAll("[^a-zA-Z0-9]", "");
        t=t.toLowerCase();
        int i=0,j=t.length()-1;
        while(i<j)
        {
            if(t.charAt(i)!=t.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
