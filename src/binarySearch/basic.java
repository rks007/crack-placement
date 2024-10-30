package binarySearch;


public class basic {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16};
        int target = 10;
        int ans = binarySearchMethod(arr, target);
        System.out.println(ans);
    }

    private static int binarySearchMethod(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
