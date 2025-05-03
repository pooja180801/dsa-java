public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.insertAtBeginning(5);
        list.insertAtBeginning(9);
        list.insertAtBeginning(7);
        list.insertAtBeginning(3);
        list.display();

        System.out.println(" ");
        list.insertAtPos(1,8);
        list.display();
        System.out.println(" ");
        list.reverse();
        list.display();

        list.deleteAtPos(0);
        list.display();

        System.out.println(" ");

        for(int a:list)
            System.out.println(a + " ");

    }
}
