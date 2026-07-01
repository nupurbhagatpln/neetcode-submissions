class Solution {

    private final String[] telephone= new String[]{
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
       
       List<String> ans= new ArrayList<>(); 
        if(digits.length()==0)  return ans;
        bracktrack(digits,0,"",ans);
        return ans; 
    }

    private void bracktrack(String d,int i,String subset, List<String> ans )
    {
        if(subset.length()==d.length())
        {
            ans.add(subset);
            return;
        }
        String chars= telephone[d.charAt(i)-'0'];

        for(char c: chars.toCharArray())
        {
            bracktrack(d, i+1, subset+c,ans);
        }        
    }
}
