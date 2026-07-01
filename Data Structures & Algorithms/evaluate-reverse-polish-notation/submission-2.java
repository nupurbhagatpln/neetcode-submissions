class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st= new Stack<>();
    

        for(int i=0 ;i<tokens.length;i++)
        {
            if(tokens[i].equals("+")|| tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/") )
            {
                int op2=Integer.parseInt(st.pop());
                int op1=Integer.parseInt(st.pop());
                int temp;
                if(tokens[i].equals("+")) temp=(op1+op2);
                else if(tokens[i].equals("-")) temp=(op1-op2);
                else if(tokens[i].equals("*")) temp=(op1*op2);
                else  temp=(op1/op2);
                st.push(String.valueOf(temp));
                
            }
            else{
                st.push(tokens[i]);
            }
        }
        return Integer.valueOf(st.peek());
        
    }
}
