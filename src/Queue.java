import java.util.Stack;

public class Queue<T> {

    private final Stack<T> stack1;
    private final Stack<T> stack2;
    private int n = 10;

    public Queue(int n) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        this.n = n;
    }

    public void push(T data) {
        stack1.push(data);
        if(stack1.size() > n) MoveStack();
    }

    public T pop() {
        if(stack2.empty()) MoveStack();
        return stack2.pop();
    }

    private void MoveStack() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public boolean empty()  {
        return stack1.empty() && stack2.empty();
    }

    @Override
    public String toString() {
        return stack1.toString() + stack2.toString();
    }
}

