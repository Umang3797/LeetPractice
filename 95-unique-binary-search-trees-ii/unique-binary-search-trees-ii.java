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
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
    private List<TreeNode> solve(int start, int end){
        if(start>end){
            List<TreeNode> bs=new ArrayList();
            bs.add(null);
            return bs;
        }
        List<TreeNode> ans = new ArrayList();

        for(int i=start;i<=end;i++){
            List<TreeNode> left=solve(start,i-1);
            List<TreeNode> right=solve(i+1,end);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}