class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map of Roman numerals to integers
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        // Step 2: Initialize result
        int total = 0;
        int prevValue = 0;
        
        // Step 3: Iterate forward through the Roman numeral string
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanMap.get(s.charAt(i));

            // Step 4: Check if the next character exists and is greater
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                total -= currentValue; // Subtract for subtractive cases
            } else {
                total += currentValue; // Otherwise, add the value
            }
        }

        return total;
        
    }
}