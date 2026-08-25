/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();

                if(node == null){
                    result += ",null";
                    continue;
                }

                result += "," + node.val;
               
                queue.offer(node.left);
                            
                queue.offer(node.right);            
            }
        }
        return result.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }

        String [] values = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        int index = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();

            if(!values[index].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                parent.left = left;
                queue.offer(left);
            }

            index++;

            if (!values[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                parent.right = right;
                queue.offer(right);
            }

            index++;            
        }
        return root;
    }
}
