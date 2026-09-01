import java.util.*;

class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> prefixSum = new HashMap<>();

        // Empty path has sum 0
        prefixSum.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixSum);
    }

    private int dfs(TreeNode node,
                    long currentSum,
                    int targetSum,
                    Map<Long, Integer> prefixSum) {

        if (node == null) {
            return 0;
        }

        // Add current node to prefix sum
        currentSum += node.val;

        // Number of paths ending here with target sum
        long required = currentSum - targetSum;

        int count = prefixSum.getOrDefault(required, 0);

        // Add current prefix sum
        prefixSum.put(
            currentSum,
            prefixSum.getOrDefault(currentSum, 0) + 1
        );

        // Explore left and right
        count += dfs(
            node.left,
            currentSum,
            targetSum,
            prefixSum
        );

        count += dfs(
            node.right,
            currentSum,
            targetSum,
            prefixSum
        );

        // Backtrack:
        // remove current prefix sum before returning
        prefixSum.put(
            currentSum,
            prefixSum.get(currentSum) - 1
        );

        return count;
    }
}