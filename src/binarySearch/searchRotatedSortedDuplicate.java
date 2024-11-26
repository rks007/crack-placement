package binarySearch;

public class searchRotatedSortedDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1};
        int target = 0;
        int ans = searchBinary(arr, target);
        System.out.println(ans);
    }
    private static int searchBinary(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
            } else if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
