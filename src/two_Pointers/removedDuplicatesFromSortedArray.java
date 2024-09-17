package two_Pointers;

public class removedDuplicatesFromSortedArray { //leetcode 26
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; //ans is 5;

        int ans = removeDuplicates(nums);

        System.out.println(ans);

    }
    public static int removeDuplicates(int[] nums) {//for better understanding dry run
        int n = nums.length;
        //using two pointer approach
        int i = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] > nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
