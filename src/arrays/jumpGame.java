package arrays;

public class jumpGame { //leetcode 55 
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++){

            if(i > maxReach){ //agar reach se aage badh gaya toh matlab not possible
                return false;
            }

            int reach = nums[i] + i;
            maxReach = Math.max(maxReach, reach);

            if(maxReach >= nums.length - 1){
                return true;
            }
        }

        return false;
    }
}
