class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode node) {

        // Empty node contributes 0
        if (node == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        int left = Math.max(0, dfs(node.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, dfs(node.right));

        // Path passing through current node
        int currentPath = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return maximum one-sided path
        return node.val + Math.max(left, right);
    }
}