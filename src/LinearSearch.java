import java.util.Arrays;

class LinearSearchImp{
    public static int find(int[] arr, int val){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }

    public static int find(String str, char target){
        str = str.toLowerCase();
        target = Character.toLowerCase(target);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == target){
                return i;
            }
        }
        return -1;
    }

    public static int[] find(int[][] arr, int target){
        for(int row=0; row< arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                if(arr[row][col] == target){
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {-1, -1};
    }
}

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 3, 2, 8, 4, 1};
        int pos = LinearSearchImp.find(arr, 2);
        boolean ans = LinearSearchImp.contains(arr, 2);

        System.out.println(pos + " " + ans);

        String name = "Pooja";
        int charPos = LinearSearchImp.find(name, 'p');
        System.out.println("charpos "+ charPos);

        int[][] twoDArr = {
                {2, 5, 3},
                {3, 7, 3},
                {8, 3, 2}
        };


        int[] twoDArrAns  = LinearSearchImp.find(twoDArr, 7);
        System.out.println(Arrays.toString(twoDArrAns));
    }
}
