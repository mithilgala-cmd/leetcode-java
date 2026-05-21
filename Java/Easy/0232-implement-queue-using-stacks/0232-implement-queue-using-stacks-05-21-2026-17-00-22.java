class MyQueue {

    private Deque<Integer> in;
    private Deque<Integer> out;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        move();
        return out.pop();
    }
    
    public int peek() {
        move();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */