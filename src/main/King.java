package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static main.ChessConstants.COL_OFFSETS;
import static main.ChessConstants.ROW_OFFSETS;

public class King extends ChessPiece {

    public King() {
        super(PieceType.KING);
    }

    @Override
    public List<String> getPossibleMoves(String currentCell, ChessBoard chessBoard) {
        int row = chessBoard.getCellRow(currentCell);
        int column = chessBoard.getCellColumn(currentCell);

        return calculateMoves(row, column, chessBoard);
    }

    private List<String> calculateMoves(int startRow, int startColumn, ChessBoard chessBoard) {
        return IntStream.range(0, ROW_OFFSETS.length)
                .mapToObj(i ->
                        chessBoard.getCell(startRow + ROW_OFFSETS[i], startColumn + COL_OFFSETS[i]))
                .filter(cell -> !cell.isEmpty())
                .sorted()
                .collect(Collectors.toList());
    }

}
