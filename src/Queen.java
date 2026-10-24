public class Queen extends ChessPiece {

    public Queen(String color) {
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

        if (line == toLine && column == toColumn) return false;

        int dl = Math.abs(toLine - line);
        int dc = Math.abs(toColumn - column);
        if (line != toLine && column != toColumn && dl != dc) return false;

        // идем по клеткам до цели, все должны быть пустые
        int stepL = Integer.signum(toLine - line);
        int stepC = Integer.signum(toColumn - column);
        int steps = Math.max(dl, dc);
        for (int i = 1; i < steps; i++) {
            if (chessBoard.board[line + i * stepL][column + i * stepC] != null) return false;
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}