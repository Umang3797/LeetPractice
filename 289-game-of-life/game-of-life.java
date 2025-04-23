class Solution {
    final int direction[][]=
        {{0,-1},{0,1},{-1,0},{1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        
        if(board==null || board.length==0){
            return;
        }

        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==0){
                    int lives=count(board,i,j);
                    if(lives==3){
                        board[i][j]=-1; //dead->live=-1
                    }
                }
                if(board[i][j]==1){
                    int lives=count(board,i,j);
                    if(lives<2 || lives>3){
                        board[i][j]=2;  //live->dead=2
                    }
                }
            }
        }
        update(board);
    }

    private int count(int[][] board, int row, int col){
        int res=0;
        for(int[] dir : direction){
            int newrow = row+dir[0];
            int newcol = col+dir[1];

            //boundary check
            if(newrow>=0 && newrow<board.length && 
            newcol>=0 && newcol<board[0].length && 
            (board[newrow][newcol]==1 || board[newrow][newcol]==2)){
                res++;
            }
        }
        return res;
    }

    private void update(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j]=1;
                }
                if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }
    }
}