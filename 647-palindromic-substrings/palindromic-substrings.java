class Solution {
    public int countSubstrings(String s) {  
        if (s == null || s.length() < 1) return 0;
        String res = "";
        int count=0;

        for (int i = 0; i < s.length(); i++) {
            count+= expandAroundCenter(s, i, i);     // Odd-length palindrome
            count+= expandAroundCenter(s, i, i + 1); // Even-length palindrome

            // Update res to the longer one
            // if (odd.length() > res.length()) res = odd;
            // if (even.length() > res.length()) res = even;
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int localcount=0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            localcount++;
        }
        return localcount;
    }
}