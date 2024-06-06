class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves=0;
        
        while(target>1){
            if(target %2==0 && maxDoubles>0){
                target = target/2;
                maxDoubles = maxDoubles -1;
                moves++;
                continue;
            }
            if(maxDoubles==0){
                moves = moves + (target-1);
                break;
            }
            else{
                target = target-1;
                moves++;
            }
        }
        return moves;
        
    }
}