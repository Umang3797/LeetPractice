class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        LinkedList<Integer> res = new LinkedList<>();
        
        int p = num.length - 1;
        int carry = 0;
        
        while (p >= 0 || k > 0 || carry != 0) {
            int x1 = (p >= 0) ? num[p] : 0;
            int x2 = k % 10;
            
            int sum = x1 + x2 + carry;
            res.addFirst(sum % 10);
            carry = sum / 10;
            
            k /= 10;
            p--;
        }
        if(carry!=0){
            res.addFirst(carry);
        }
        
        return res;
    }
}