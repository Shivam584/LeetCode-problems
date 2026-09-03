class Solution {
    public int[] plusOne(int[] digits) {
           int n = digits.length;
        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {

            digits[i] += carry;

            carry = digits[i] / 10;
            digits[i] %= 10;

            if (carry == 0)
                return digits;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = carry;

        for (int i = 0; i < n; i++) {
            newDigits[i + 1] = digits[i];
        }

        return newDigits;
    }
}