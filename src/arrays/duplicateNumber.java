package arrays;

import java.util.HashMap;

public class duplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }
    public static int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
            else {
                mp.put(nums[i], 1);
            }
        }

        for (int i = 0; i < nums.length;i++){
            int val = mp.get(nums[i]);
            if(val > 1){
                return nums[i];
            }
        }
        return -1;
    }
}
