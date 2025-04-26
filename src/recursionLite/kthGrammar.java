package recursionLite;

public class kthGrammar { //leetcode 779
    class Solution {
        public int kthGrammar(int n, int k) {
            int ans = solve(n, k);;
            return ans;
        }
        public int solve(int n, int k){
            // Base case: The first row, first symbol is always 0
            if (n == 1 && k == 1) {
                return 0;
            }

            // Find the middle position of the current row
            int mid = (int) Math.pow(2, n - 1) / 2; // length of row (2^(n-1)), so mid is 2^(n-2)

            if (k <= mid) {
                // If k is in the first half, it is the same as in the previous row
                return solve(n - 1, k);
            } else {
                // If k is in the second half, it is the flip of (k - mid)th symbol in previous row
                return 1 - solve(n - 1, k - mid); // flipping 0 to 1 or 1 to 0
            }
        }
    }
}
