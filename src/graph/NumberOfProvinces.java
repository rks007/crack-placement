package graph;

import java.util.ArrayList;

public class NumberOfProvinces { //547 leetcode
    public int findCircleNum(int[][] isConnected) {
        //first convert it into adj list
        int numberOfVertex = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numberOfVertex; i++ ){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < numberOfVertex; i++){
            for(int j = 0; j < numberOfVertex; j++){
                if(isConnected[i][j] == 1 && i != j){
                    int u = i;
                    int v = j;

                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }

        //now just write the dfs code
        boolean[] vis = new boolean[numberOfVertex];
        int count = 0;
        for(int vertex = 0; vertex < vis.length; vertex++){
            if(!vis[vertex]){
                dfs(adj, vertex, vis);
                count++;//just add this to get your answer
            }
        }

        return count;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] vis){
        vis[vertex] = true;

        for(var e : adj.get(vertex)){
            if(!vis[e]){
                dfs(adj, e, vis);
            }
        }
    }
}
