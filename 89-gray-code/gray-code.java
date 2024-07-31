class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            List<Integer> templist = new ArrayList<>();
            templist.add(0);
            templist.add(1);
            return templist;
        }
        
        List<Integer> recursionresult = grayCode(n - 1);
        List<Integer> myresult = new ArrayList<>();
        
        // Adding leading 0 to the previous result
        for (int i = 0; i < recursionresult.size(); i++) {
            myresult.add(recursionresult.get(i));
        }
        
        // Adding leading 1 to the previous result in reverse order
        int addNumber = 1 << (n - 1);
        for (int i = recursionresult.size() - 1; i >= 0; i--) {
            myresult.add(addNumber + recursionresult.get(i));
        }
        
        return myresult;
    }
}