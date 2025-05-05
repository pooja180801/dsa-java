class CircularLinkedListImp<T> {
    Node last;
    class Node{
        T data;
        Node next;

        Node(T val){
            data = val;
            next = null;
        }
    }

    CircularLinkedListImp(){
        last = null;
    }

    public void insertAtBeginning(T val){
        Node newNode = new Node(val);

        if(last == null){
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    public void insertAtEnd(T val){
        Node newNode = new Node(val);

        if(last == null){
            newNode.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        last = newNode;
    }

    public void display(){
        if(last == null){
            return;
        }
        Node temp = last.next;

        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp != last.next);
    }

    public void deleteAtBeginning(){
        if(last==null){
            throw new IndexOutOfBoundsException("deletion not allowed in an empty array");
        }

        if(last.next == last){
            last = null;
        }  else {
            last.next = last.next.next;
        }
    }

    public void deleteAtEnd(){
        if(last==null){
            throw new IndexOutOfBoundsException("deletion not allowed in an empty array");
        }

        if(last.next == last){
            last = null;
        } else {
            Node temp = last.next;

            while(temp.next != last){
                temp = temp.next;
            }

            temp.next = last.next;
            last = temp;
        }
    }
}


public class CircularLinkedList{
    public static void main(String[] args) {
        CircularLinkedListImp<String> list = new CircularLinkedListImp<String>();

        list.insertAtBeginning("pooja");
        list.insertAtBeginning("abi");
        list.insertAtBeginning("jumbo");
        list.insertAtBeginning("linga");
        list.insertAtEnd("kulam");
        list.insertAtEnd("chandra");
        list.display();

    }
}
