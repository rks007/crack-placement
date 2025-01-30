package binarySearch;

import java.util.Arrays;
import java.util.Collections;

public class kokoEatingBananas {
    public static void main(String[] args) {
        int[] arr = {30,11,23,4,20};
        int h = 5;

        int ans = minBananasInHour(arr, h);
        System.out.println(ans);

    }
    private static int minBananasInHour(int[] arr, int h){
        int start = 1; // Minimum possible eating speed (at least 1 banana per hour)
        int end = Arrays.stream(arr).max().getAsInt(); // Maximum pile size (worst case speed)
        int ans = end; // Initialize answer with the worst case scenario

        // Apply binary search on eating speed
        while (start <= end) {
            int mid = start + (end - start) / 2; // Mid represents the candidate speed

            // Check if Koko can finish eating within h hours at this speed
            if (isSatisfyThanH(arr, mid, h)) {
                ans = mid; // Update the answer since we found a possible minimum speed
                end = mid - 1; // Try for a smaller speed
            } else {
                start = mid + 1; // Increase speed since current speed is too slow
            }
        }
        return ans;
    }

    private static boolean isSatisfyThanH(int[] arr, int k, int h){
        int totalHours = 0; // To count the total hours required

        // Calculate the number of hours needed for each pile
        for (int bananas : arr) {
            totalHours += Math.ceil((double) bananas / k); // Rounds up to account for remaining bananas
        }

        // If total hours needed is within the available hours, return true
        return totalHours <= h;
    }
}
