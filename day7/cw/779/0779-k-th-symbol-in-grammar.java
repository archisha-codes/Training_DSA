class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        
        // Find the length of the row above (which is 2^(n-2))
        int mid = (int) Math.pow(2, n - 2);
        
        // If k is in the first half, it's the same as the previous row
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            // If k is in the second half, it's the flipped version of the first half
            return kthGrammar(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}