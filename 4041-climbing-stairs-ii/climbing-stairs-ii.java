class Solution {
    public int climbStairs(int n, int[] costs) {
        if (n == 0)
            return 0;

        int a = 0, b = costs[0] + 1, c = 0, temp = 0;

        if (n == 1)
            return b;

        c = costs[1] + Math.min(b + 1, a + 4);

        if (n == 2)
            return c;

        for (int i = 3; i <= n; i++) {
            temp = costs[i - 1] + Math.min(c + 1, Math.min(b + 4, a + 9));
            a = b;
            b = c;
            c = temp;
        }

        return c;
    }
}