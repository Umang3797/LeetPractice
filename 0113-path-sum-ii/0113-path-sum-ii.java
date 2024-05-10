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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList();
        List<Integer> currentPath = new ArrayList();
        dfshelper(root,targetSum,allPaths,currentPath);
        return allPaths;
    }
    private void dfshelper(TreeNode root, int targetSum, List<List<Integer>> allPaths,  List<Integer> currentPath){
        if(root==null){
            return;
        }
        
        currentPath.add(root.val);
        
        
        if(root.val==targetSum && root.left==null && root.right==null){
            allPaths.add(new ArrayList(currentPath));
        }else{
            dfshelper(root.left,targetSum-root.val,allPaths,currentPath);
            dfshelper(root.right,targetSum-root.val,allPaths,currentPath);

        }
        
        currentPath.remove(currentPath.size()-1);
        
        
        
        
        
        
    }
}