🧠 Clone Graph using BFS – Java Revision Note
✅ Problem
Clone (deep copy) a connected undirected graph where each node contains a value and a list of neighbors.

✅ Key Concepts
Graph Traversal (BFS)

HashMap to avoid visiting nodes multiple times

Node Mapping from original to cloned nodes

✅ Code Explanation

class Solution {
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

✅ Time & Space Complexity
Time Complexity: O(N + E)
Where N = number of nodes and E = number of edges.

Space Complexity: O(N)
For storing the HashMap and BFS queue.

✅ Summary
This solution uses Breadth-First Search (BFS) to traverse and clone the graph.
A HashMap is used to keep track of already cloned nodes, ensuring:

No node is cloned more than once.

Original and cloned nodes are properly mapped.

Let me know if you'd like:

A DFS-based version

A dry-run example

Or a visual diagram for better understanding!