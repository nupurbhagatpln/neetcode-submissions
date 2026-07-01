class Solution {
    /*
    Approach:
    ababd : bab
    consider each i to middle and expand to its left and right
    check left and right bound and also string charcter in left and right
    handle the even case by keeping left =i right i+1
    return the max length substring

    */
    public String longestPalindrome(String s) {
        int res=0;
        String str="";
        for(int i=0;i<s.length();i++)
        {
            //odd case;
            int left=i,right=i;
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right))
            {
                if(res<(right-left+1))
                {
                    res= right-left+1;
                    str=s.substring(left,right+1);
                }
                left--;
                right++;
            }
            // even

            left=i;right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right))
            {
                if(res<(right-left+1))
                {
                    res= right-left+1;
                    str=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return str;
        
    }
}
