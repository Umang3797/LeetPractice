/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, or root is p, or root is q, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively find the LCA in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Recursively find the LCA in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If p and q are found in different subtrees, root is their LCA
        if (left != null && right != null) {
            return root;
        }
        
        // If both nodes are found in the left subtree, return left
        // Otherwise, return right
        return left != null ? left : right;
    }
}