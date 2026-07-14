class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st= new Stack<>();
        int area=0;
        int s=0;
        int n= heights.length;
        for(int i=0;i<n;i++)
        {
            s=i;

            while(!st.isEmpty() && st.peek()[1]> heights[i])
            {
                int[] t= st.pop();
                area= Math.max(area, t[1]*(i-t[0]));
                s=t[0];
            }

            st.push(new int[]{s, heights[i]});
        }

        while(!st.isEmpty())
        {
            int[] t= st.pop();
            area= Math.max(area, t[1]*(n-t[0]));
        }

        return area;
    }
}
