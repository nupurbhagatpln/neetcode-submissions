class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st= new Stack<>();
        minSt= new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || val<=minSt.peek())
        {
            minSt.push(val);
        }
        
    }
    
    public void pop() {
        if(st.isEmpty())    return;
        int top= st.pop();
        if(minSt.peek()==top)
        {
            minSt.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minSt.peek(); 
    }
}
