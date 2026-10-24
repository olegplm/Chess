public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        int dir = color.equals("White") ? 1 : -1;   // белые идут вверх, черные вниз
        int start = color.equals("White") ? 1 : 6;
        ChessPiece target = chessBoard.board[toLine][toColumn];

        if (column == toColumn) {
            if (target != null) return false;   // прямо пешка не бьет
            if (toLine - line == dir) return true;
            return line == start && toLine - line == 2 * dir && chessBoard.board[line + dir][column] == null;
        }

        // взятие по диагонали
        if (Math.abs(toColumn - column) == 1 && toLine - line == dir) {
            return target != null && !target.getColor().equals(color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}