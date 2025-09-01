package graph;

import java.util.Scanner;

public class dijkstraAlgo {  //time complexity O(V^2) in adjacency matrix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int adjmat[][] = new int[v][v];
        for (int i = 0; i < e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            adjmat[v1][v2] = weight;
        }
        int fromV = sc.nextInt(); //source vertex for the algo
        int distance[] = new int[v];

        dijkstra(adjmat, distance, fromV);

        for (int i = 0; i < v; i++){
            System.out.println(distance[i]+" ");
        }
    }

    private static void dijkstra(int[][] adjmat, int[] distance, int fromV) {
        int v = adjmat.length;
        boolean visited[] = new boolean[v];
        distance[fromV] = 0;

        for(int i = 0; i < v; i++){
            if(i == fromV)continue;
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < v; i++){
            int minV = findMinV(distance, visited);
            visited[minV] = true;
            for(int j = 0; j < v; j++){
                if(adjmat[minV][j] != 0 && visited[j] == false && distance[minV] != Integer.MAX_VALUE){
                    int newDist = distance[minV] + adjmat[minV][j];
                    if(newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }
    }

    private static int findMinV(int[] distance, boolean[] visited) {
        int minV = -1;
        for(int i = 0; i < distance.length; i++){
            if(visited[i] == false && (minV == -1 || distance[i] < distance[minV])){
                minV = i;
            }
        }
        return minV;
    }
}
