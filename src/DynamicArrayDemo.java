import java.util.Scanner;

class DynamicArray {
int[] array;
int size;

public DynamicArray(){
    array = new int[2];
    size = 0;
}

public void add(int val){
    ensureCapacity();
    array[size++]=val;
}

public void display(){
    if(size==0){
        System.out.println("No data to display");
    }
    else {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
}

public void insertAtPos(int pos,int val){
    if (pos > size) {
        System.out.println("Position out of bounds.");
        return;
    }
    ensureCapacity();
    for(int i = size-1; i > pos; i--){
        array[i]=array[i-1];
    }
    array[pos]=val;
    size++;
}

public void deleteAtPos(int pos){
    if (pos > size) {
        System.out.println("Position out of bounds.");
        return;
    }
    for (int i = pos; i < size - 1; i++) {
        array[i] = array[i + 1];
    }
    size--;
}

    private void ensureCapacity() {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
}

public class DynamicArrayDemo {
    public static void main(String[] args) {
        int val,pos;
        DynamicArray list = new DynamicArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n ------- List Menu --------");
            System.out.println("1.Insert at end \n");
            System.out.println("2.Display the list \n");
            System.out.println("3.Insert at specified position \n");
            System.out.println("4.Delete from specified position \n");
            System.out.println("5.Exit \n");
            System.out.println("\n----------------------------------");
            System.out.println("Enter your choice \t");

            int choice = scanner.nextInt();

            switch (choice){
                case 1: System.out.println("Enter the data");
                    val = scanner.nextInt();
                    list.add(val);
                    break;

                case 2: list.display();
                    break;

                case 3: System.out.println("Enter the position(starts at 0): ");
                    pos = scanner.nextInt();
                    if(pos<0){
                        System.out.println("invalid position");
                        break;
                    }
                    System.out.println("Enter the data");
                    val = scanner.nextInt();
                    list.insertAtPos(pos,val);
                    break;

                case 4: System.out.println("Enter the position(starts at 0): ");
                    pos = scanner.nextInt();
                    if(pos<0){
                        System.out.println("invalid position");
                        break;
                    }
                    list.deleteAtPos(pos);
                    break;

                case 5: System.exit(0);

                default: System.out.println("Invalid Choice");
            }
        }
    }
}
