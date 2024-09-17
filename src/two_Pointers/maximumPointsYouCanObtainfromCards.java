package two_Pointers;

public class maximumPointsYouCanObtainfromCards { //leetcode 1423


        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;

            // Calculate the sum of the first k cards from the start
            int currentSum = 0;
            for (int i = 0; i < k; i++) {
                currentSum += cardPoints[i];
            }

            // Initialize the maximum score with the sum of the first k cards
            int maxScore = currentSum;

            // Use a sliding window to consider taking cards from the end instead of the start
            for (int i = 0; i < k; i++) {
                // Subtract the i-th card from the start and add the i-th card from the end
                currentSum = currentSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
                maxScore = Math.max(maxScore, currentSum);
            }

            return maxScore;
        }


}
