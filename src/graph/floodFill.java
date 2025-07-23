package graph;

public class floodFill { //leetcode 733
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc]; //kyu ki start color fic nhi hai, 1 bhi ya kuch aur bhi ho sakta

        // Optimization: If the start color and new color are same, no need to proceed
        if (startColor != color) { //imp line other wise there is chnace of infinite recursion
            dfs(image, sr, sc, startColor, color);
        }
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int startColor, int color){

        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == startColor){
            image[sr][sc] = color;
            dfs(image, sr + 1, sc, startColor, color);
            dfs(image, sr - 1, sc, startColor, color);
            dfs(image, sr, sc + 1, startColor, color);
            dfs(image, sr, sc - 1, startColor, color);
        }
    }
}
