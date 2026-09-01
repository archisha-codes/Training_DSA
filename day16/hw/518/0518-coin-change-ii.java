class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        // There is one way to make amount 0:
        // choose nothing.
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}