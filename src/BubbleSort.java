import java.util.Arrays;

class BubbleSortImp {
    public static void sort(int[] arr){
        for(int i=1; i< arr.length;i++){
            boolean swapped = false;
            for(int j=0;j< arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(!swapped){
                break;
            }
        }
    }
}

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10,5,26,7,15,2,55};
        BubbleSortImp.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
