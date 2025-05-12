import java.util.Arrays;

class QuickSortImp{
    public static void sort(int[] arr,int l,int h){
        if(l>=h)
            return;

        int s=l,e=h;

        int mid = (l+h)/2;
        int pivot = arr[mid];

        while (s<=e){
            while(arr[s]<pivot)
                s++;
            while (arr[e]>pivot)
                e--;

            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        sort(arr,l,e);
        sort(arr,s,h);
    }
}

public class QuickSort {
    public static void main(String[] args) {
        int[] inp = {5,8,2,4,3,9,7,1};
        QuickSortImp.sort(inp,0,inp.length-1);
        System.out.println(Arrays.toString(inp));
    }
}
