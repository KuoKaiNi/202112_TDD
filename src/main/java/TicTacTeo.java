public class TicTacTeo {

    private String board[][];
    private String symbol[];
    private int sequence;

    public TicTacTeo() {
        board = new String[3][3];
        symbol = new String[2];
        symbol[0] = "O";
        symbol[1] = "X";
    }

    public void play(int x, int y) {
        if (x > 3)
            throw new RuntimeException("X is ouside board");
        if (y > 3)
            throw new RuntimeException("Y is ouside board");
        if (!(board[x - 1][y - 1] == null))
            throw new RuntimeException("Position has another symbol");
        board[x - 1][y - 1] = symbol[sequence % 2];
        sequence++;
    }

    public String checkPositionResult(int x, int y) {
        return board[x - 1][y - 1];
    }

    private boolean checkDiagonalLineIn() {
        if (board[1][1] == null)
            return false;
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if (board[2][0] == board[1][1] && board[0][2] == board[1][1])
            return true;
        return false;
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++) {
            int oSymbolCount_X = 0;
            int xSymbolCount_X = 0;

            int oSymbolCount_Y = 0;
            int xSymbolCount_Y = 0;

            for (int j = 0; j < 3; j++) {
                if (!(board[i][j] == null)) {
                    if ("O".equals(board[i][j])) {
                        oSymbolCount_X++;
                    } else {
                        xSymbolCount_X++;
                    }
                }

                if (!(board[j][i] == null)) {
                    if ("O".equals(board[j][i])) {
                        oSymbolCount_Y++;
                    } else {
                        xSymbolCount_Y++;
                    }
                }
            }
            if (oSymbolCount_X == 3 || xSymbolCount_X == 3 || oSymbolCount_Y == 3 || xSymbolCount_Y == 3 || checkDiagonalLineIn()) {
                return true;
            }
        }
        return false;
    }

    public String winner() {
        return symbol[(sequence - 1) % 2];
    }

    public boolean isDraw() {
        if (sequence >= 9) return true;
        return false;
    }
}
