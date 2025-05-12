import java.util.Arrays;

class InsertionSortImp{
    public static void sort(int[] arr){
        for(int i = 1; i< arr.length; i++){
            for(int j=i; j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 26, 7, 15, 2, 55};
        InsertionSortImp.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
