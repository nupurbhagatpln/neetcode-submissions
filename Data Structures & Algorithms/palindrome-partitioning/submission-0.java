class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result= new ArrayList<>();
        List<String> subset= new ArrayList<>();

        dfs(0,s,result, subset);
        return result;
        
    }

    private void dfs(int i, String s, List<List<String>> result, List<String> subset)
    {
        // base cond:
        if(i>= s.length())
        {
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            if(ispallin(s,i,j))
            {
                subset.add(s.substring(i,j+1));
                dfs(j+1,s,result,subset);
                subset.remove(subset.size()-1);
            }
        }
    }

    private boolean ispallin(String str, int i, int j)
    {
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
