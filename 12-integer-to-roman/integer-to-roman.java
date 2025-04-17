class Solution {
    public String intToRoman(int num) {
        // Step 1: Create a LinkedHashMap to store Roman numeral values in descending order
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
        
        // Step 2: Initialize result StringBuilder
        StringBuilder result = new StringBuilder();
        
        // Step 3: Iterate through the map
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            
            // Step 4: Append symbol if num is divisible by value
            int count = num / value; // Get how many times the value fits in num
            if (count > 0) {
                result.append(symbol.repeat(count)); // Append symbol count times
                num = num % value; 
            }
        }
        return result.toString();
    }
}