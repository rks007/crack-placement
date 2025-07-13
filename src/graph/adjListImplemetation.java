package graph;

import java.util.ArrayList;
import java.util.Scanner;



public class adjListImplemetation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < vertex; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        printGraphDfs(adj);
    }

    private static void printGraphDfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        helperDfs(adj, 0, visited);
    }

    private static void helperDfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(adj.get(vertex));

        for(var e : adj.get(vertex)){
            if(visited[e] != true){
                helperDfs(adj, e, visited);
            }
        }
    }
}
