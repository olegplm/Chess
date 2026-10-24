public class Horse extends ChessPiece {

    public Horse(String color) {
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
        if (!(dl == 2 && dc == 1 || dl == 1 && dc == 2)) return false;

        // конь прыгает, проверяем только клетку куда идем
        ChessPiece target = chessBoard.board[toLine][toColumn];
        return target == null || !target.getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}