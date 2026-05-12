/*
Definition for a Node.
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
}
*/

class Solution {

    private HashMap<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {return null;}
        return bfs(node);
    }

    private Node bfs(Node node) {
        nodeMap.put(node, new Node(node.val));
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node poppedNode = queue.removeFirst();
            for(Node neighbor : poppedNode.neighbors) {
                if(!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                nodeMap.get(poppedNode).neighbors.add(nodeMap.get(neighbor));
            }
        }

        return nodeMap.get(node);
    }
}