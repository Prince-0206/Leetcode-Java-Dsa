class MinStack {
    Stack<Long> st = new Stack<>();
    long min;

    public MinStack() {}

    public void push(int value) {
        if(st.isEmpty()){
            st.push(0L);
            min = value;
        } else {
            st.push((long)value - min);
            if(value < min) min = value;
        }
    }

    public void pop() {
        long top = st.pop();
        if(top < 0){
            min = min - top; 
        }
    }

    public int top() {
        long top = st.peek();
        if(top < 0){
            return (int)min;
        } else {
            return (int)(min + top);
        }
    }

    public int getMin() {
        return (int)min;
    }
}