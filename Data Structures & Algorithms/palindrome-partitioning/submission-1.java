class Solution {
    List<List<String>> result= new ArrayList<>();
    public List<List<String>> partition(String s) {

        List<String> pallin= new ArrayList<>();

        backtrack(0,s,pallin);
        return result;
    }

    private void backtrack(int i, String s, List<String> pallin)
    {
        if(i>= s.length())
        {
            result.add(new ArrayList<>(pallin));
            return;
        }
        for(int k=i;k<s.length();k++)
        {
            if(isPallin(s,i,k))
            {
                pallin.add(s.substring(i,k+1));
                backtrack(k+1,s,pallin);
                pallin.remove(pallin.size()-1);
            }
        }
    }

    private boolean isPallin(String s, int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
