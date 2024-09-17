package unboundedKnapsackDPTypes;

public class unboundedKnapSackR { //code 360

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        if(n == 0 || w == 0){
            return 0;
        }

        if(weight[n - 1] <= w){
            return Math.max(profit[n - 1] + unboundedKnapsack(n, w - weight[n - 1], profit, weight), unboundedKnapsack(n - 1, w, profit, weight));
        }

        return unboundedKnapsack(n - 1, w, profit, weight);
    }
}
