class StackUsingLinkedListImp {
    Node top;
    class Node{
        int data;
        Node next;

        Node(int val){
            data = val;
            next = null;
        }
    }

    StackUsingLinkedListImp(){
        top = null;
    }

    void push(int val){
        Node newNode = new Node(val);

        newNode.next = top;
        top = newNode;
    }

    int pop(){
        if(top == null){
            throw new IndexOutOfBoundsException("stack underflow");
        }

        int n = top.data;
        top = top.next;

        return n;
    }

    int peak(){
        if(top == null){
            throw new IndexOutOfBoundsException("stack underflow");
        }

        return top.data;
    }
}

public class StackUsingLinkedList{
    public static void main(String[] args) {
        StackUsingLinkedListImp s = new StackUsingLinkedListImp();
        s.push(4);
        s.push(5);
        System.out.println("peak"+ s.peak());
        System.out.println("pop " + s.pop());
        System.out.println("peak"+ s.peak());
    }
}
