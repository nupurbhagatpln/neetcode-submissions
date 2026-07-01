class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
    

        for(int i=0 ;i<tokens.length;i++)
        {
            if(tokens[i].equals("+")|| tokens[i].equals("*") || 
            tokens[i].equals("-") || tokens[i].equals("/") )
            {
                int op2=(st.pop());
                int op1=(st.pop());
                int temp;
                if(tokens[i].equals("+")) temp=(op1+op2);
                else if(tokens[i].equals("-")) temp=(op1-op2);
                else if(tokens[i].equals("*")) temp=(op1*op2);
                else  temp=(op1/op2);
                st.push(temp);
                
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
        
    }
}
