class MyStack {
    Deque<Integer> st;
    public MyStack() {
        st= new LinkedList<>();
    }
    
    public void push(int x) {
        if(st.isEmpty())
        {
            st.offer(x);
        }
        else{
            st.addLast(x);
        }
        
    }
    
    public int pop() {
        return st.removeLast();
    }
    
    public int top() {
        return st.peekLast(); 
    }
    
    public boolean empty() {
        return st.isEmpty(); 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */