public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)
                || !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        int dl = Math.abs(toLine - line);
        int dc = Math.abs(toColumn - column);
        if (dl > 1 || dc > 1 || dl + dc == 0) return false;

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (!board.checkPos(line) || !board.checkPos(column)) return false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece p = board.board[i][j];
                if (p == null || p.getColor().equals(color)) continue;

                if (p.getSymbol().equals("P")) {
                    // пешка бьет по диагонали, а не так как ходит
                    int dir = p.getColor().equals("White") ? 1 : -1;
                    if (line - i == dir && Math.abs(column - j) == 1) return true;
                } else if (p.canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
