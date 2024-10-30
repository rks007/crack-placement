package binarySearch;

public class countOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int target = 3;
        int first = countOccurrenceOfTarget(arr, target, true);
        int last = countOccurrenceOfTarget(arr, target, false);

        System.out.println(last - first + 1);
    }

    private static int countOccurrenceOfTarget(int[] arr, int target, boolean forFirst) {
        int count = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                if(forFirst){
                    count = mid;
                    end = mid - 1;
                } else {
                    count = mid;
                    start = mid + 1;
                }
            }
        }
        return count;
    }
}
