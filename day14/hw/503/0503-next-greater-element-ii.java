import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice
        for (int i = 0; i < 2 * n; i++) {

            int current = nums[i % n];

            // Resolve elements smaller than current
            while (!stack.isEmpty() &&
                   nums[stack.peek()] < current) {

                result[stack.pop()] = current;
            }

            // Only store indices during the first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}