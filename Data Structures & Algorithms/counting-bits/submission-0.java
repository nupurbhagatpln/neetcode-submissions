class Solution {

    private int countBit(int n)
    {
        int ans=0;

        for(int i=0;i<32;i++)
        {
            ans += (1<<i & n)!=0 ? 1:0;
        }
        return ans;
    }
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        for(int i=0;i<n+1;i++)
        {
            ans[i]=countBit(i);
        }
        return ans;
        
    }
}
