class QueueLinkedListImp{
    class Node{
        int data;
        Node next;

        Node(int val){
            data = val;
            next = null;
        }
    }
    Node front, rear;
    QueueLinkedListImp(){
        front = null;
        rear = null;
    }

    public void enqueue(int val){
        Node newNode = new Node(val);

        if(front == null){
            front = newNode;
        } else{
            rear.next = newNode;
        }
        rear = newNode;
    }

    public int dequeue(){
        if(front == null){
            throw new IndexOutOfBoundsException("queue is empty");
        }
        int data = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }

        return data;
    }
}

public class QueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedListImp queue = new QueueLinkedListImp();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        try {
            queue.dequeue();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

