/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        //use bfs to get all the nodes 
        List<Node> nodes = getNodes(node);
        //copy nodes
        Map<Node, Node> mapping = new HashMap<>();
        for(Node n : nodes){
            mapping.put(n, new Node(n.val));
        }
        
        //copy neightbors
        for(Node n : nodes){
            for(Node neighbor : n.neighbors){
                Node newNeighbor = mapping.get(neighbor);
                mapping.get(n).neighbors.add(newNeighbor);
            }
            
        }
        return mapping.get(node);
        
    }
    private List<Node> getNodes(Node node){
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            nodes.add(cur);
            for(Node neighbor : cur.neighbors){
                if(set.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }
        return nodes;
    }
}