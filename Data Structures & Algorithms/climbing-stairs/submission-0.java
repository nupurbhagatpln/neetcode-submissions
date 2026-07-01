class Solution {
    int [] temp;
    public int climbStairs(int n) {

        temp= new int[n+1];

        for(int i=0;i<=n;i++)
        {
            temp[i]=-1;
        }

        return countStep(n,0); 
    }

    private int countStep(int n, int i)
    {
        if(i>=n)    return i==n? 1:0;

        if(temp[i]!=-1) return temp[i];

        return temp[i]= countStep(n,i+1) + countStep(n,i+2);
    }
}
