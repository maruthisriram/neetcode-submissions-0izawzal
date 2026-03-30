class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() && minStack.peek() < val){
            minStack.push(minStack.peek());

        }else{
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
