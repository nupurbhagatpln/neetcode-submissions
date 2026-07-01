class Solution {
    /*
    Approach:
    go with the approach for the middle and then
    travers towards left and right find the string is pallindrome or not if 
    yes pallindrome then just add into the array;
    */
    public int countSubstrings(String s) {

        int count=0;

        for(int i=0;i<s.length();i++)
        {
            // odd 
            int l=i,r=i;
            while(l>=0 && r< s.length() && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;r++;
            }
            //even
            l=i;r=i+1;
            while(l>=0 && r< s.length() && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;r++;
            }
        }
        return count;
        
    }
}
