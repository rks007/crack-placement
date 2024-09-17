package arrays;

public class pivotIndex { //leetcode

    //better approach tc = 0(n) and sc = 0(2n) due to two additional arrays
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];
        pre[0] = 0;
        suff[nums.length - 1] = 0;

        for(int i = 1; i < nums.length; i++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            suff[i] = suff[i + 1] + nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++){
            if(pre[i] == suff[i]){
                return i;
            }
        }
        return -1;
    }



    //optimal approach sc = 0(1)//////////////////////////////////////////
    public int pivotIndex2(int[] nums) {
        // Initialize totalSum to store the sum of all elements in the array
        int totalSum = 0;

        // Calculate the total sum of the array elements
        for(int num : nums) {
            totalSum += num;
        }

        // Initialize leftSum to store the cumulative sum of elements to the left of the current index
        int leftSum = 0;

        // Iterate through the array to find the pivot index
        for(int i = 0; i < nums.length; i++) {
            // Check if the leftSum is equal to the right sum
            // Right sum is calculated as totalSum - leftSum - nums[i]
            if(leftSum == totalSum - leftSum - nums[i]) {
                // If they are equal, return the current index as the pivot index
                return i;
            }
            // Update the leftSum by adding the current element
            leftSum += nums[i];
        }

        // If no pivot index is found, return -1
        return -1;
    }

}
