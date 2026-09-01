import java.util.*;

class Solution {

    private int postorderIndex;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store value -> index for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Last element of postorder is the root
        postorderIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // Get root from postorder
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = inorderMap.get(rootValue);

        // IMPORTANT:
        // Build right subtree first
        root.right = build(postorder, rootIndex + 1, right);

        // Then build left subtree
        root.left = build(postorder, left, rootIndex - 1);

        return root;
    }
}