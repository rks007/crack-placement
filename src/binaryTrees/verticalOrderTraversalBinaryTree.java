package binaryTrees;

import java.util.*;

public class verticalOrderTraversalBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static class Pair{
        Node  node;
        int col;
        int level;

        public Pair(Node _node, int col, int level){
            node = _node;
            this.col = col;
            this.level = level;
        }
    }

    private static List<List<Integer>> vertical(Node root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            Node node = pair.node;
            int x = pair.col;
            int y = pair.level;

            if(!mp.containsKey(x)){
                mp.put(x, new TreeMap<>());
            }
            if (!mp.get(x).containsKey(y)){
                mp.get(x).put(y, new PriorityQueue<>());
            }
            mp.get(x).get(y).add(node.val);

            if(node.left != null){
                q.add(new Pair(node.left, x - 1, y + 1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, x + 1, y + 1));
            }
        }

        System.out.println(mp.values());
        System.out.println(mp.keySet());

        // Result list to store vertical order traversal
        List<List<Integer>> result = new ArrayList<>();

        // Extract the values from the map in vertical order
        for (TreeMap<Integer, PriorityQueue<Integer>> levelMap : mp.values()) {
            List<Integer> verticalLevel = new ArrayList<>();
            for (PriorityQueue<Integer> nodesAtLevel : levelMap.values()) {
                while (!nodesAtLevel.isEmpty()) {
                    System.out.print(nodesAtLevel + " ");
                    verticalLevel.add(nodesAtLevel.poll()); // Collect nodes in sorted order
                }
            }
            result.add(verticalLevel); // Add vertical column to result
        }

        return result;
    }
    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);


        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        e.right = f;

        List<List<Integer>> result = vertical(a);

        // Print the result

        System.out.println();
        System.out.println("Vertical Traversal: ");
        printResult(result);



    }
}
