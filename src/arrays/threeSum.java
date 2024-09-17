package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum { //leetcode 15

       // brute force approach
        public static List<List<Integer>> threeSum(int[] nums) {

            HashSet<List<Integer>> st = new HashSet<>();

            for(int i = 0; i < nums.length - 2; i++){
                for(int j = i + 1; j < nums.length - 1; j++){
                    for(int k = j + 1; k < nums.length; k++){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                            temp.sort(null);
                            st.add(temp);
                        }
                    }
                }
            }
            List<List<Integer>> ans = new ArrayList<>(st);
            return ans;
        }




        //better approach for nearly n square
    public static List<List<Integer>> threeSum2(int[] nums) {
        // HashSet to store unique triplets
        HashSet<List<Integer>> st = new HashSet<>();

        // Iterate through the array, considering each element as the first element of the triplet
        for (int i = 0; i < nums.length; i++) {
            // HashSet to store the numbers needed to complete a triplet
            HashSet<Integer> tempSet = new HashSet<>();

            // Iterate through the array starting from the next element after 'i'
            for (int j = i + 1; j < nums.length; j++) {
                // Calculate the required number to make the triplet sum zero
                int k = -(nums[i] + nums[j]);

                // Check if the required number is already in the set
                if (tempSet.contains(k)) {
                    // Create a triplet and sort it to maintain a consistent order
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    temp.sort(null);

                    // Add the sorted triplet to the set of unique triplets
                    st.add(temp);
                }
                // Add the current number to the tempSet
                tempSet.add(nums[j]);
            }
        }

        // Convert the HashSet to an ArrayList and return the result
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }












}
