class Solution {
    List<String> ans= new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder stack= new StringBuilder();
        backtrack(0,0,stack,n);
        return ans;
        
    }

    private void backtrack(int open, int close, StringBuilder stack, int n)
    {
        if(open==n && close==n)
        {
            ans.add(stack.toString());
            return;
        }

        if(open<n)
        {
            stack.append("(");
            backtrack(open+1, close, stack,n);
            stack.deleteCharAt(stack.length()-1);
        }
        if(close<open)
        {
             stack.append(")");
            backtrack(open, close+1, stack,n);
            stack.deleteCharAt(stack.length()-1);   
        }
        return;
    }
}
