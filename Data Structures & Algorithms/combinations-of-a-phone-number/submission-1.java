class Solution {
    String[] telephone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result= new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)  return result;

        backtrack(digits,0,"");
        return result;
        
    }

    private void backtrack(String digits, int i, String s)
    {
        if(s.length()==digits.length())
        {
            result.add(s);
            return;
        }

        String chars= telephone[digits.charAt(i)-'0'];

        for(char c:chars.toCharArray())
        {
            backtrack(digits,i+1,s+c);
        }
    }
}
