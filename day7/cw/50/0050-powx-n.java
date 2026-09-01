class Solution {
    public double myPow(double x, int n) {
        // We cast n to long to avoid overflow issues when n is Integer.MIN_VALUE
        return helper(x, (long) n);
    }

    private double helper(double x, long n) {
        // Base case: anything to the power of 0 is 1
        if (n == 0) {
            return 1.0;
        }

        // If the power is negative, we invert x and make the power positive
        if (n < 0) {
            return helper(1 / x, -n);
        }

        // Recursively calculate half of the power
        double half = helper(x, n / 2);

        // If n is even, we just multiply the halves
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd, we need to multiply by x one more time
            return x * half * half;
        }
    }
}