package recursionLite;

import java.util.ArrayList;
import java.util.List;

public class sortArrayRecursion {
    public static void main(String[] args) {
       ArrayList<Integer> arr = new ArrayList<>(List.of(2,3,8,7,6,9));

       recursionSort(arr);


       System.out.println(arr);
    }

    private static void recursionSort(ArrayList<Integer> arr) {
        if(arr.size() == 1){
            return;
        }
        int element = arr.remove(arr.size() - 1);
        recursionSort(arr);
        insert(arr, element);
    }

    private static void insert(ArrayList<Integer> arr, int element) {
        if(arr.size() == 0 || arr.get(arr.size() - 1) <= element){
            arr.add(element);
            return;
        }
        int val = arr.remove(arr.size() - 1);
        insert(arr, element);
        arr.add(val);
        return;


    }
}
