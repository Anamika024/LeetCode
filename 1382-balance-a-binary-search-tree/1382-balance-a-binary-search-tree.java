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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return helper(0, list.size()-1, list);

        
    }
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode helper(int l, int r, List<Integer> list) {
        if(l>r) {
            return null;
        }
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(l, mid-1, list);
        root.right = helper(mid+1, r, list);
        return root;
    }
}