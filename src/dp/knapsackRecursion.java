package dp;

public class knapsackRecursion { //gfg practice
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base case: If no items left (n == 0) or weight capacity is 0 (W == 0)
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is less than or equal to the capacity W
        if (wt[n - 1] <= W) {
            // Return the maximum of two cases:
            // 1. nth item included in the knapsack
            // 2. nth item not included in the knapsack
            return Math.max(
                    val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), // Case 1: Include nth item
                    knapSack(W, wt, val, n - 1) // Case 2: Exclude nth item
            );
        }
        // If weight of the nth item is more than the capacity W
        else {
            // Exclude the nth item from the knapsack
            return knapSack(W, wt, val, n - 1);
        }
    }

}
