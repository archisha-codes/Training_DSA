class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int needed = 1, current = 0;
            for (int w : weights) {
                if (current + w > mid) {
                    needed++;
                    current = 0;
                }
                current += w;
            }
            if (needed <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
