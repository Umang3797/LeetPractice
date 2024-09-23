class Solution {
    public String customSortString(String order, String s) {
//         //Map to maintain frequency
//         Map<Character,Integer> map = new HashMap();
        
//         for(int i=0;i<s.length();i++){
//             map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0)+1);
//         }
        
//         StringBuilder sb = new StringBuilder();
        
//         // Append characters from 'order' in the specified order
//         for (int i = 0; i < order.length(); i++) {
//             if (map.containsKey(order.charAt(i))) {
//                 // Append the character according to its frequency
//                 int count = map.get(order.charAt(i));
//                 for (int j = 0; j < count; j++) {
//                     sb.append(order.charAt(i));
//                 }
//                 // Remove the character from the map after processing
//                 map.remove(order.charAt(i));
//             }
//         }
        
//         // Append remaining characters that were not in 'order'
//         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//             char ch = entry.getKey();
//             int count = entry.getValue();
//             for (int j = 0; j < count; j++) {
//                 sb.append(ch);
//             }
//         }
        
        
        
//         return sb.toString();
        
        // Create an array to hold the counts of each character
        int[] charCount = new int[26];
        
        // Count the frequency of each character in s
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Append characters from 'order' in the specified order
        for (char ch : order.toCharArray()) {
            int index = ch - 'a'; // Convert character to index
            while (charCount[index] > 0) {
                sb.append(ch);
                charCount[index]--; // Decrement the count
            }
        }
        
        // Append remaining characters that were not in 'order'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a'; // Convert character to index
            while (charCount[index] > 0) {
                sb.append(ch);
                charCount[index]--; // Decrement the count
            }
        }
        
        return sb.toString();
        
    }
}