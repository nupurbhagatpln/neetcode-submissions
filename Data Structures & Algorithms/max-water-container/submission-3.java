class Solution {
    public int maxArea(int[] heights) {

        int i=0;
        int n= heights.length;
        int j= n-1;

        int ans=0;

        while(i<j)
        {
            ans= Math.max(ans, (j-i)*Math.min(heights[j],heights[i]));
            if(heights[i]<heights[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return ans;
        
    }
}
