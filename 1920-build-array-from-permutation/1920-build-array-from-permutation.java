class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        // Encode both old and new values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        // Decode to get the new values
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }

        return nums;
    }
}