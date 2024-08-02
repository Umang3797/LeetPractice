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
    int totalsum=0;
    public int sumNumbers(TreeNode root) {
        preOrder(root,0);
        return totalsum;
    }
    private void preOrder(TreeNode root, int sum){
        if(root==null){
            return;
        }
        sum = sum *10 + root.val;
        if(root.left==null && root.right==null){
            totalsum+=sum;
        }
        preOrder(root.left,sum);
        preOrder(root.right,sum);
    }
}