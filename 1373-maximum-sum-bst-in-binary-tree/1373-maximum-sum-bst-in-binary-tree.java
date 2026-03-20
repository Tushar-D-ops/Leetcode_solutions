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
 class NodeValue{
    int sum;
    int max;
    int min;
    public NodeValue(int sum,int max,int min){
        this.sum=sum;
        this.max=max;
        this.min=min;
    }
 }
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        func(root);
        return ans;
    }
    NodeValue func(TreeNode root){
        if(root==null){
            return new NodeValue(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        NodeValue left=func(root.left);
        NodeValue right=func(root.right);
        if(left.max<root.val && right.min>root.val){
            int temp=root.val+left.sum+right.sum;
            ans=Math.max(ans,temp);
            return new NodeValue(temp,Math.max(right.max,root.val),Math.min(left.min,root.val));
        }
        return new NodeValue(Math.max(left.sum,right.sum),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}