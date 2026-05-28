class Solution {
/*
    Approach:
    2 variable : leftMin=0, leftmax=0;
    iterate through the string :
        if we found '(' : i need to increase leftMin & leftMax 
        else if we found ")" : decreament by 1 both 
        else (*): leftMin -- & leftMax++;
        if any case leftmax<0 -> return false;
        if any case we found leftMin<0 -> leftMin=0;
    
    check if(leftMin<=leftMax)-> true;
    return false;
*/
    public boolean checkValidString(String s) {
        int leftMin=0,leftMax=0;
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                leftMin++;
                leftMax++;
            }
            else if(c==')')
            {
                leftMin--;  leftMax--;
               
            }
            else{
                leftMin--;
                leftMax++;
            }
            if(leftMin<0)   leftMin=0;
            if(leftMax<0)   return false;
        }

        if(leftMin==0)   return true;
        return false;
        
    }
}
