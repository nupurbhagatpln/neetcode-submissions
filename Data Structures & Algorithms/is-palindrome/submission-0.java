class Solution {
    public boolean isPalindrome(String s) {
        List<Character> chararr=new ArrayList<>();
    
        for(char ch:s.toCharArray())
        {
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') ||(ch>='0' &&ch<='9'))
           {
            chararr.add(Character.toLowerCase(ch));
           } 
        }
        int i=0, j=chararr.size()-1;
        while(i<=j)
        {
            if(chararr.get(i)!=chararr.get(j))
            {
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
