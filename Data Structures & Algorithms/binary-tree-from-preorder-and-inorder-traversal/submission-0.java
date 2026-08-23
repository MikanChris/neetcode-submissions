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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return dfs(preorder, 0, preorder.length - 1, 
                    inorder, 0, inorder.length - 1);

    }

    public TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){

        if(preStart > preEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inStart;

        while(inorder[rootIndex] != root.val){
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = dfs(preorder, preStart + 1, preStart + leftSize, 
                        inorder, inStart, rootIndex - 1);

        root.right = dfs(preorder, preStart + leftSize + 1, preEnd,
                        inorder, rootIndex + 1, inEnd);
        
        return root;
    }
}
