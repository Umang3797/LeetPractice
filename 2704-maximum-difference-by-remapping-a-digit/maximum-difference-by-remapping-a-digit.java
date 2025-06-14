class Solution {
    public int minMaxDifference(int num) {
        // Convert number to char array
        char[] digits = String.valueOf(num).toCharArray();

        // Build max number
        char targetForMax = ' ';
        for (char ch : digits) {
            if (ch != '9') {
                targetForMax = ch;
                break;
            }
        }

        char[] maxDigits = digits.clone();
        if (targetForMax != ' ') {
            for (int i = 0; i < maxDigits.length; i++) {
                if (maxDigits[i] == targetForMax) {
                    maxDigits[i] = '9';
                }
            }
        }

        // Build min number
        char targetForMin = digits[0];
        char[] minDigits = digits.clone();
        for (int i = 0; i < minDigits.length; i++) {
            if (minDigits[i] == targetForMin) {
                minDigits[i] = '0';
            }
        }

        int maxVal = Integer.parseInt(String.valueOf(maxDigits));
        int minVal = Integer.parseInt(String.valueOf(minDigits));

        return maxVal - minVal;
    }
}