class Solution {
    long[][][] t;
    static final long NEG = Long.MIN_VALUE / 4;

    long dp(int i, int n, int k, int fg, int[] nums) {

        if (k == 0)
            return 0;

        // Not enough elements left to form k subarrays
        if (n - i < k || i == n)
            return NEG;

        if (t[i][k][fg] != NEG)
            return t[i][k][fg];

        long k1 = (long) k;
        long value = (k % 2 == 1)
                ? k1 * nums[i]
                : -k1 * nums[i];

        t[i][k][fg] = value + Math.max(
                dp(i + 1, n, k, 1, nums),
                dp(i + 1, n, k - 1, 1, nums)
        );

        // If we are outside a subarray, we can skip nums[i]
        if (fg == 0) {
            t[i][k][fg] = Math.max(
                    dp(i + 1, n, k, 0, nums),
                    t[i][k][fg]
            );
        }

        return t[i][k][fg];
    }

    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;

        t = new long[n][k + 1][2];

        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                t[i][j][0] = t[i][j][1] = NEG;

        return dp(0, n, k, 0, nums);
    }
}