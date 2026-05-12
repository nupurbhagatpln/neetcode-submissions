class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int res=0;
        // odd length
        for(int i=0;i<s.length();i++)
        {
            int l=i, r=i;

            while(l>=0 && r<s.length() && s.charAt(l)== s.charAt(r))
            {
                if(res< (r-l+1))
                {
                    ans= s.substring(l,r+1);
                    res= (r-l+1);
                }
                r++;
                l--;
            }
        }
        //even
        for(int i=0;i<s.length();i++)
        {
            int l=i, r=i+1;

            while(l>=0 && r<s.length() && s.charAt(l)== s.charAt(r))
            {
                if(res< (r-l+1))
                {
                    ans= s.substring(l,r+1);
                    res= (r-l+1);
                }
                r++;
                l--;
            }
        }
        return ans;
    }
}
