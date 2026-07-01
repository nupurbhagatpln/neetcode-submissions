class Solution {
    // 1- false 2- true
    public boolean isMatch(String s, String p) {

        int[][] dp= new int[s.length()+1][p.length()+1];

        return dfs(0,0,s,p,dp)==2;
    }

    private int dfs(int i, int j, String s, String p, int[][] dp)
    {
        if (j == p.length()) {
            return i == s.length() ? 2 : 1;
        }

        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        boolean firstMatch= i<s.length() &&(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j));

        if((j+1)<p.length() && p.charAt(j+1)=='*')
        {
            int skip= dfs(i,j+2,s,p,dp);
            if(skip==2)
            {
                return dp[i][j]=2;
            }
            if(firstMatch)
            {
                int use = dfs(i+1,j,s,p,dp);
                if(use==2)
                {
                    return dp[i][j]=2;
                }
            }
            dp[i][j]=1;
        }
        if(firstMatch)
        {
            int t= dfs(i+1,j+1,s,p,dp);
            return dp[i][j]=t;
        }
        return dp[i][j]=1;
    }
}
