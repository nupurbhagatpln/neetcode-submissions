class Solution {

    // Approach
    
    /*
        use stack : to maintain the index and heightb
        here for every index we need to keep track start index from where we can 
        start counting the area.

        this happen only if we have increasing height 
        else  we pop from stack and update with start index for that index area

    */
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> st= new Stack<>();
        int area=0;
        int start=0;
        int size=heights.length;
        for(int i=0; i<heights.length;i++)
        {
            start=i;
            while(!st.isEmpty() && st.peek()[1]> heights[i])
            {
                int m=st.peek()[0];
                int h=st.peek()[1];
                st.pop();
                area= Math.max(area, h*(i-m));
                start=m;
            }
            st.push(new int[]{start,heights[i]});
        }

        while(!st.isEmpty())
        {
            int i=st.peek()[0];
            int h=st.peek()[1];
            st.pop();
            area=Math.max(area, h*(size-i));
        }
        return area;
    }
}
