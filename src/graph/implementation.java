package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertex");
        int v = sc.nextInt();
        System.out.println("Enter the number edges");
        int e = sc.nextInt();
        int[][] adj_mat = new int[v][v];
        for(int i = 0; i < e; i++){
            int startingVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            adj_mat[startingVertex][endVertex] = 1;
            adj_mat[endVertex][startingVertex] = 1;
        }

        System.out.println("DFS output");
        printDfs(adj_mat);
        System.out.println("BFS output");
        printBfs(adj_mat);
    }

    public static void printBfs(int[][] adj_mat){ //bigO(v + e)  spaceComplexity= BigO(v)
        boolean[] visited = new boolean[adj_mat.length];
        for(int i = 0; i < visited.length; i++){  //this loop is to print the disconnected components
            if(visited[i] == false){
                printBfsHelper(adj_mat, i, visited);
            }
        }
    }

    private static void printBfsHelper(int[][] adj_mat, int startVertex, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        visited[startVertex] = true;
        while(!q.isEmpty()){
            int front = q.poll();
            System.out.println(front);
            for(int i = 0; i < adj_mat.length; i++){
                if(adj_mat[front][i] == 1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printDfs(int[][] adj_mat){ // bigO(v + e)  spaceComplexity = bigO(v)
        int length = adj_mat.length;
        boolean[] visited = new boolean[length];
        for(int i = 0; i < visited.length; i++){ //this loop is to print the disconnected components
            if(visited[i] == false){
                printDfsHelper(adj_mat, i, visited);
            }
        }

    }

    private static void printDfsHelper(int[][] adj_mat, int startVertex, boolean[] visited) {
        System.out.println(startVertex);
        visited[startVertex] = true;
        for (int i = 0; i < adj_mat.length; i++){
            if(adj_mat[startVertex][i] == 1 && visited[i] == false){
                printDfsHelper(adj_mat, i, visited);
            }
        }
    }


}
