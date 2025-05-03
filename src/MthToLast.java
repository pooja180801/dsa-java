import java.io.*;

public class MthToLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the value of m (position from the end)
        int m = Integer.parseInt(br.readLine().trim());

        // Read list elements as space-separated values
        String[] elements = br.readLine().trim().split(" ");

        // Initialize the linked list
        linkedList list = new linkedList();

        // Insert elements into the linked list
        for (String val : elements) {
            list.insertAtLast(Integer.parseInt(val));
        }

        // Get the size of the list (it's just the length of elements)
        int size = elements.length;

        // If m is larger than the list size, print "NIL"
        if (m > size) {
            System.out.println("NIL");
        } else {
            // Call getMthToLast to get the m-th to last element
            int result = list.getMthToLast(m);
            System.out.println(result);
        }
    }
}

class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}

class linkedList {
    Node head;
    Node tail;

    linkedList() {
        head = null;
        tail = null;
    }

    public void insertAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int getMthToLast(int m) {
        Node fast = head;
        Node slow = head;

        // Move the fast pointer m steps ahead
        for (int i = 0; i < m; i++) {
            if (fast == null) return -1; // m is larger than list size
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Return the data of the slow pointer (m-th to last element)
        return (slow != null) ? slow.data : -1;
    }
}
