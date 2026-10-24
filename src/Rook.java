public class Rook extends ChessPiece {

    public Rook(String color) {
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
        if (line != toLine && column != toColumn) return false;

        if (line == toLine) {
            for (int c = Math.min(column, toColumn) + 1; c < Math.max(column, toColumn); c++) {
                if (chessBoard.board[line][c] != null) return false;
            }
        } else {
            for (int l = Math.min(line, toLine) + 1; l < Math.max(line, toLine); l++) {
                if (chessBoard.board[l][column] != null) return false;
            }
        }

        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}