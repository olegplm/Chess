public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        int d = Math.abs(toLine - line);
        if (d == 0 || d != Math.abs(toColumn - column)) return false;

        int stepL = toLine > line ? 1 : -1;
        int stepC = toColumn > column ? 1 : -1;
        for (int i = 1; i < d; i++) {
            if (chessBoard.board[line + i * stepL][column + i * stepC] != null) return false;
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}