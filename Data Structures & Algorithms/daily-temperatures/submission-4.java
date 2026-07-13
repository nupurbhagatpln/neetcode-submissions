class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st= new Stack<>();
        int n= temp.length;
        int[] ans= new int[n];
        st.push(n-1);
        int i=n-2;
        while(i>=0)
        {
            if(temp[st.peek()]>temp[i])
            {
                ans[i]=st.peek()-i;
                st.push(i);
            }
            else{
                while( !st.isEmpty() && temp[st.peek()]<=temp[i])
                {
                    st.pop();
                }
                ans[i]= st.isEmpty() ? 0: st.peek()-i;
                st.push(i);
            }
            i--;

        }
        return ans;
        
    }
}
