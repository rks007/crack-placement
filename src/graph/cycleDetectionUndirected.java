package graph;

import java.util.ArrayList;

public class cycleDetectionUndirected {

        public boolean isCycle(int V, int[][] edges) {
            // Code here
            //First converting it into adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean[] vis = new boolean[V];
            for(int i = 0; i < V; i++){
                if(vis[i] != true){
                    if(dfs(adj, i, -1, vis)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(ArrayList<ArrayList<Integer>> adj, int vertex, int parent, boolean[] vis){
            vis[vertex] = true;

            for(var e : adj.get(vertex)){
                if(!vis[e]){
                    if(dfs(adj, e, vertex, vis)){
                        return true;
                    }
                } else if(e != parent){
                    return true;
                }
            }
            return false;
        }

}
