import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    Node head;

    class Node{
        T data;
        Node next;
        Node(T val){
            data = val;
            next = null;
        }
    }

    LinkedList(){
        head=null;
    }

    public void insertAtBeginning(T val){
        Node newNode = new Node(val);

        //when list is empty
        if(head==null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void display(){
        Node temp = head;

        if(head==null){
            System.out.println("The List is empty!");
        }

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void insertAtPos(int pos, T val){

        if (pos==0){
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;

        for(int i=0; i < pos-1; i++){
            temp = temp.next;
            if(temp==null){
                throw new IllegalArgumentException("Invalid Position" + pos);
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtBeginning(){
        if(head==null){
            throw new IndexOutOfBoundsException("deletion not allowed in an empty array");
        }

        head=head.next;
    }

    public void deleteAtPos(int pos){
        if(head==null){
            throw new IndexOutOfBoundsException("deletion not allowed in an empty array");
        }

        if(pos==0){
            head=head.next;
            return;
        }

        Node temp=head;
        Node prev=null;

        for(int i=0;i<pos;i++){
            prev=temp;
            temp=temp.next;

            if(temp==null){
                throw new IllegalArgumentException("Invalid Position" + pos);
            }
        }

        prev.next=temp.next;
    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node temp=head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }

            @Override
            public T next() {
                T val=temp.data;
                temp=temp.next;
                return val;
            }
        };
    }

    public void reverse(){
        Node prev=null;
        Node current=head;
        Node next;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        head=prev;
    }

    public T getMthToLast(int m){
        Node fast = head;
        Node slow = head;


        for(int i = 0; i < m; i++){
            if(fast == null){
                throw new IllegalArgumentException("Invalid Position" + m);
            }
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        if (slow==null){
            throw new IllegalArgumentException("Invalid Position" + m);
        }
        return slow.data;
    }

    public void insertAtLast(T val) {
        Node newNode = new Node(val);
        Node tail = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}