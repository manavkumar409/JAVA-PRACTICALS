class OverflowException extends RuntimeException { OverflowException(String msg) { super(msg); } }
class UnderflowException extends RuntimeException { UnderflowException(String msg) { super(msg); } }

class Stack {
    private int[] arr;
    private int top, cap;

    Stack(int size) { cap = size; arr = new int[cap]; top = -1; }

    void push(int val) {
        if (top == cap - 1) throw new OverflowException("Stack Overflow");
        arr[++top] = val;
    }

    int pop() {
        if (top == -1) throw new UnderflowException("Stack Underflow");
        return arr[top--];
    }

    int peek() {
        if (top == -1) throw new UnderflowException("Stack is Empty");
        return arr[top];
    }
}

class Queue {
    private int[] arr;
    private int front, rear, size, cap;

    Queue(int cap) { this.cap = cap; arr = new int[cap]; front = size = 0; rear = cap - 1; }

    void enqueue(int val) {
        if (size == cap) throw new OverflowException("Queue Overflow");
        rear = (rear + 1) % cap;
        arr[rear] = val;
        size++;
    }

    int dequeue() {
        if (size == 0) throw new UnderflowException("Queue Underflow");
        int val = arr[front];
        front = (front + 1) % cap;
        size--;
        return val;
    }

    int front() {
        if (size == 0) throw new UnderflowException("Queue is Empty");
        return arr[front];
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Stack s = new Stack(2);
            s.push(10); s.push(20);
            System.out.println("Stack Popped: " + s.pop());

            Queue q = new Queue(2);
            q.enqueue(100); q.enqueue(200);
            System.out.println("Queue Dequeued: " + q.dequeue());
            System.out.println("Queue Front: " + q.front());

            q.enqueue(300);
            q.enqueue(400); // Triggers Overflow
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

