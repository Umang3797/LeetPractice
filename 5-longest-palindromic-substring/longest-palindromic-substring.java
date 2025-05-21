class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);     // Odd-length palindrome
            String even = expandAroundCenter(s, i, i + 1); // Even-length palindrome

            // Update res to the longer one
            if (odd.length() > res.length()) res = odd;
            if (even.length() > res.length()) res = even;
        }

        return res;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // return the valid palindrome
    }
}
