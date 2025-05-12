import java.util.Arrays;

class SelectionSortImp{
    public static void sort(int[] arr){
        for(int i = 0; i< arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }
}

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10,5,26,7,15,2,55};
        BubbleSortImp.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
