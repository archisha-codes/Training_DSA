class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return ans;
    }

    void backtrack(int[] nums, List<Integer> current) {

        // All elements are used
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try every element
        for (int i = 0; i < nums.length; i++) {

            // Skip if already used
            if (current.contains(nums[i])) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, current);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}