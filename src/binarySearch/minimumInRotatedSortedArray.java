package binarySearch;


public class minimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3,};
        int ans = searchBinary(nums);
        System.out.println(ans);
    }

    private static int searchBinary(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            if(nums[start] <= nums[end]){
                return nums[start];
            }

            int mid = start + (end - start) / 2;

            if(nums[mid] >= nums[start]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return 0;
    }
}
