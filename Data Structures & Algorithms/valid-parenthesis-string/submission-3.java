class Solution {
    // aproach just to maintain the range of leftmin, left max for "( , *"
    // if the range (m, n) include 0 then its true 
    // else false
    public boolean checkValidString(String s) {
        int leftmin=0, leftmax=0;

        for(char ch: s.toCharArray())
        {
            if(ch=='(')
            {
                leftmin++;
                leftmax++;
            }
            else if(ch==')')
            {
                leftmin--;
                leftmax--;
            }
            else{
                leftmin--;
                leftmax++;
            }

            if(leftmin<0)   leftmin=0;

            if(leftmax<0)   return false;
        }

        return leftmin==0; 
    }
}
