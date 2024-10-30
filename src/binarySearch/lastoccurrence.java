package binarySearch;

public class lastoccurrence {
    public static void main(String[] args) {
         int[] arr = {3,4,13,13,13,20,40};
         int target = 13;
         int ans = searchLastOccurrence(arr, target);
         System.out.println(ans);
    }

    private static int searchLastOccurrence(int[] arr, int target) {
         int lastindex = -1;
         int start = 0;
         int end = arr.length - 1;
         while(start <= end){
             int mid = start + (end - start) / 2;
             if(target < arr[mid]){
                 end = mid - 1;
             } else if (target > arr[mid]) {
                 start = mid + 1;
             } else {
                 lastindex = Math.max(lastindex, mid);
                 start = mid + 1;
             }
         }
         return lastindex;
    }
}
