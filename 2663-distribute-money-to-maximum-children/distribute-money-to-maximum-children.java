class Solution {
    public int distMoney(int money, int children) {
        int ans = 0;
    
        // Case 1: Not enough money to give $1 to each
        if (money < children)
            return -1;

        // Case 2: More money than max possible (8 * children)
        if (money > children * 8)
            return children - 1;
        
        // Greedy: assign $8 to as many as possible
        while (money > 0 && money - 8 >= children - 1) {
            ans++;
            money -= 8;
            children--;
        }

        // Special case: leftover would force the last child to get 4
        if (money == 4 && children == 1) ans--;

        return ans;
    }
}