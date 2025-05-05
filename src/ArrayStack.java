class ArrayStackImp<T> {
    static final int MAX_SIZE = 30;
    T arr[] = (T[]) new Object[MAX_SIZE];
    int top;

    ArrayStackImp(){
        top = -1;
    }

    void push(T val){
        if(top == MAX_SIZE-1){
            throw new IndexOutOfBoundsException("stack is full");
        }
        arr[++top] = val;
    }

    T pop(){
        if(top == -1){
            throw new IndexOutOfBoundsException("stack underflow");
        }
        //after sending top val decrement the top
        return arr[top--];
    }

    T peak(){
        return arr[top];
    }
}

public class ArrayStack{
    public static void main(String[] args) {
        ArrayStackImp<Integer> stack = new ArrayStackImp<Integer>();

        stack.push(4);
        stack.push(8);

        System.out.println("popped " + stack.pop());
    }
}
