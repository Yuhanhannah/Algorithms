/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        // add all nodes to arraylist
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i) == null){
                continue;
            }
            nodes.add(nodes.get(i).left);
            nodes.add(nodes.get(i).right);
        }
        //get rid of the nulls from the tail
        while(nodes.get(nodes.size() - 1) == null) {
            nodes.remove(nodes.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val);
        for(int i = 1; i < nodes.size(); i++) {
            if(nodes.get(i) == null){
                sb.append(",null");
            }else{
                sb.append("," + nodes.get(i).val);
            }
        }
        sb.append("}");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "[]"){
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        nodes.add(root);
        
        int index = 0;
        boolean isLeftChild = true;
        for(int i = 1; i < vals.length; i++){
            if(!vals[i].equals("null")){
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeftChild){
                    nodes.get(index).left = node;
                }else{
                     nodes.get(index).right = node;
                }
                nodes.add(node);
            }
            if(!isLeftChild){
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));