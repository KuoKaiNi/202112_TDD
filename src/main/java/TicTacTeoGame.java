public class TicTacTeoGame {

    private String board[][];
    private String pieces[];

    private int sequence;

    public TicTacTeoGame(){
        board = new String[3][3];
        pieces = new String[2];
        pieces[0] = "O";
        pieces[1] = "X";
        sequence = 0;
    }

    public void play(int x, int y) {
        if (x > 3)
            throw new RuntimeException("X Axis Outside!");
        if (y > 3)
            throw new RuntimeException("Y Axis Outside!");
        if (!(board[x-1][y-1]==null))
            throw new RuntimeException("Non Space Area!");
        board[x-1][y-1] = pieces[sequence%2];
        sequence++;
    }

    public String getPiece(int x, int y) {
        return board[x-1][y-1];
    }

    private boolean isDiagonalLinein(){
        if (board[1][1]==null) return false;
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) return  true;
        if (board[2][0] == board[1][1] && board[2][0]==board[0][2]) return  true;
        return false;
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++){
            int xAxis_Symbol_O_Count = 0;
            int xAxis_Symbol_X_Count = 0;
            int yAxis_Symbol_O_Count = 0;
            int yAxis_Symbol_X_Count = 0;
            for (int j = 0 ; j < 3; j++){
                if(!(board[i][j]==null)){
                    if (board[i][j].equals("O")) yAxis_Symbol_O_Count++;
                    if (board[i][j].equals("X")) yAxis_Symbol_X_Count++;
                }
                if (!(board[j][i]==null)){
                    if (board[j][i].equals("O")) xAxis_Symbol_O_Count++;
                    if (board[j][i].equals("X")) xAxis_Symbol_X_Count++;
                }
            }
            if (xAxis_Symbol_O_Count == 3 || xAxis_Symbol_X_Count == 3 || yAxis_Symbol_O_Count == 3 || yAxis_Symbol_X_Count == 3)
                return true;
        }
        return isDiagonalLinein();
    }

    public String getWinner() {
        return pieces[(sequence-1)%2];
    }

    public boolean isDraw() {
        if (!isWin()&&sequence==9)
            return true;
        return false;
    }
}
