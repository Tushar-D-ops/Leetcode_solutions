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
    TreeNode first;
    TreeNode prev;
    TreeNode middle;
    TreeNode last;
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        func(root);
        if(first!=null & last!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else{
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
    }
    void func(TreeNode root){
        if(root==null) return;
        func(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        func(root.right);

    }
}