public class DoublyLinkedList {
    Node head;
    Node tail;

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int n){
            data = n;
            next = null;
            prev = null;
        }
    }

    DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void insertAtBeginning(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void display(){

        if(head == null){
            System.out.println("list is empty");
        }

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void reverse(){

        if(head == null){
            System.out.println("list is empty");
        }

        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    public void insertAtPos(int pos, int val){
        if(head == null){
            System.out.println("list is empty");
        }

        if(pos == 1){
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;

        // pos start from 1
        for(int i = 1; i < pos-1; i++){
            temp = temp.next;
            if(temp == null){
                throw new IllegalArgumentException("Invalid Position" + pos);
            }
        }

        newNode.prev = temp;
        newNode.next = temp.next;

        if(temp == tail){
            tail = newNode;
        } else{
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    public void deleteAtPos(int pos) {
        // Check if the list is empty
        if (head == null) {
            throw new IndexOutOfBoundsException("Deletion not allowed in an empty list");
        }

        // Deletion at the beginning (position 1)
        if (pos == 1) {
            head = head.next;

            // If the list becomes empty after deletion
            if (head == null) {
                tail = null;
            } else {
                head.prev = null; // Disconnect the previous pointer
            }
            return;
        }

        Node temp = head;

        // Traverse to the node at the given position
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IllegalArgumentException("Invalid Position " + pos); // Invalid position
            }
        }

        // If deleting the last node (tail)
        if (temp == tail) {
            temp.prev.next = null; // Disconnect from previous node
            tail = temp.prev;      // Update tail reference
        } else {
            // Deleting a middle node
            temp.prev.next = temp.next; // Bypass current node from previous
            temp.next.prev = temp.prev; // Bypass current node from next
        }

    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element is: " + slow.data);
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(5);
        list.insertAtBeginning(9);
        list.insertAtBeginning(7);
        list.insertAtBeginning(3);
        list.insertAtBeginning(8);
        list.display();
        System.out.println("\n");
        list.reverse();
        System.out.println("\n");
        list.insertAtPos(1,4);
        System.out.println("\n");
        list.display();
        System.out.println("\n");
        list.reverse();
        System.out.println("\n");
        list.findMiddle();
    }
}
