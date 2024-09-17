package twoDimensionalArrays;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix { //leetcode
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        // Return an empty list if the matrix is empty
        if (matrix.length == 0) return ans;

        int n = matrix.length;    // Number of rows in the matrix
        int m = matrix[0].length; // Number of columns in the matrix

        // Define boundaries for the current layer of the spiral
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        // Loop until all elements are added to the result list
        while (ans.size() != matrix.length * matrix[0].length) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Check if there are more rows to process
            if (top <= bottom) {
                // Traverse from right to left along the bottom boundary
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Check if there are more columns to process
            if (left <= right) {
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return ans; // Return the list containing elements in spiral order
    }

}
