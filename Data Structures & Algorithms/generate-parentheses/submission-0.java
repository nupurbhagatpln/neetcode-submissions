class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans= new ArrayList<>();
        StringBuilder stack= new StringBuilder();

        bracktrack(0,0,n,ans,stack);
        return ans;   
    }

    private void bracktrack(int open, int close, int n, List<String> ans, StringBuilder stack)    {
        if(open==n && close==n)
        {
            ans.add(stack.toString());
            return;
        }
        if(open<n)
        {
            stack.append("(");
            bracktrack(open+1,close,n,ans,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if(close<open)
        {
            stack.append(")");
            bracktrack(open,close+1,n,ans,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        return;
    }

}    