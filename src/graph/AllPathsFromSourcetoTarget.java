package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget { //leetcode 797
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, curr, graph, graph.length - 1, res);
        return res;
    }
    private void dfs(int src, List<Integer> curr, int graph[][], int dest, List<List<Integer>> res){
        if(src == dest){
            res.add(new ArrayList(curr));
            return;
        }
        for(int a : graph[src]){ //why calling a 2d matrix like single array is explined in question on leetcode
            curr.add(a);
            dfs(a, curr, graph, dest, res);
            curr.remove(curr.size() - 1);
        }
    }
}
