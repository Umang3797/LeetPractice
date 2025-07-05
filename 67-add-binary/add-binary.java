// class Solution {
//     public String addBinary(String a, String b) {
//         return Integer.toBinaryString(
//             Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
//         );
//     }
// }
class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        
        while (p1 >= 0 || p2 >= 0) {
            int x1 = (p1 >= 0) ? a.charAt(p1) - '0' : 0;
            int x2 = (p2 >= 0) ? b.charAt(p2) - '0' : 0;
            
            int sum = x1 + x2 + carry;
            res.append(sum % 2);
            carry = sum / 2;
            
            p1--;
            p2--;
        }
        
        if (carry != 0)
            res.append(carry);
        
        return res.reverse().toString();
    }
}



       
        
        