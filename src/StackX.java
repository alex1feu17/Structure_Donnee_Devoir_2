public class StackX<T> {

    private int maxSize;
    private T[] stackArray;
    private int top;

    public StackX(int size)
    {
        maxSize = size;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }
    public void push(T j)
    {
        stackArray[++top] = j;
    }

    public T pop()
    {
        return stackArray[top--];
    }

    public T peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize-1);
    }

    public int size()
    {
        return top+1;
    }

    public T peekN(int n)
    {
        return stackArray[n];
    }

}
