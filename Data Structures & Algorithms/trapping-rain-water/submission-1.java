class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefix=new int[n];
        int[] surfix=new int[n];
        int ans=0;
        prefix[0]=height[0];
        surfix[n-1]=height[n-1];

        for(int i=1,j=n-2;i<n&& j>=0;i++,j--)
        {
            prefix[i]=Math.max(prefix[i-1],height[i]);
            surfix[j]=Math.max(surfix[j+1],height[j]);
        }
        

        for(int i=0;i<n;i++)
        {
            int t=Math.min(prefix[i],surfix[i])-height[i];
            System.out.println(t);
            ans+= t;
        }
        return ans;
        
    }
}
