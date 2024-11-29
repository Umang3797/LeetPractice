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
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap();
        return cloneUtil(node,map);
    }
    
    private Node cloneUtil(Node node, HashMap<Node,Node> map){
        Node newnode = new Node(node.val);
        map.put(node,newnode);
        
        for(Node neighbor: node.neighbors){
            if(!map.containsKey(neighbor)){
                //no clone
                newnode.neighbors.add(cloneUtil(neighbor,map));
                
            }else{
                newnode.neighbors.add(map.get(neighbor));
            }
        }
        return newnode;
    }        
}