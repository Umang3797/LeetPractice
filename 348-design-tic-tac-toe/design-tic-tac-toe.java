class TicTacToe {
    int row[];
    int col[];
    int diag=0;
    int adiag=0;
    int n;

    public TicTacToe(int n) {
        this.n=n;
        row=new int[n];
        col=new int[n];
    }
    
    public int move(int r, int c, int player) {
        int inc = 1;
        if (player == 2) inc = -1;

        row[r] += inc;
        if (row[r] == n || row[r] == -n) return player;

        col[c] += inc;
        if (col[c] == n || col[c] == -n) return player;

        if (r == c) {
            diag += inc;
            if (diag == n || diag == -n) return player;
        }

        if (r + c == n - 1) {
            adiag += inc;
            if (adiag == n || adiag == -n) return player;
        }

        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */