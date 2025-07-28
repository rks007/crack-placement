package graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
} // class Node is provided by the leetcode

public class cloneGraph { //very much imp  leetcode 133

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null; // If the input node is null, return null.
        }

        HashMap<Node, Node> mp = new HashMap<>(); // Maps original node to its clone
        Queue<Node> q = new LinkedList<>();       // Used for BFS traversal

        q.add(node);
        mp.put(node, new Node(node.val, new ArrayList<>())); // Clone and map the first node

        while (!q.isEmpty()) {
            Node h = q.poll(); // Dequeue for BFS

            for (Node neighbor : h.neighbors) {
                if (!mp.containsKey(neighbor)) {
                    mp.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor); // Add to queue if not already cloned
                }
                mp.get(h).neighbors.add(mp.get(neighbor)); // Link cloned neighbor
            }
        }

        return mp.get(node); // Return the clone of the starting node
    }

}
