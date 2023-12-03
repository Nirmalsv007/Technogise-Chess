package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static main.ChessConstants.COL_OFFSETS;
import static main.ChessConstants.ROW_OFFSETS;

public class Queen extends ChessPiece {
    public Queen() {
        super(PieceType.QUEEN);
    }

    @Override
    public List<String> getPossibleMoves(String currentCell, ChessBoard chessBoard) {
        int row = chessBoard.getCellRow(currentCell);
        int col = chessBoard.getCellColumn(currentCell);

        return calculateMoves(row, col, chessBoard);
    }

    private List<String> calculateMoves(int startRow, int startColumn, ChessBoard chessBoard) {
        return IntStream.range(0, ROW_OFFSETS.length)
                .mapToObj(i -> getAllMovesInDirection(startRow, startColumn, ROW_OFFSETS[i], COL_OFFSETS[i], chessBoard))
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getAllMovesInDirection(
            int startRow, int startColumn, int rowOffset, int colOffset, ChessBoard chessBoard) {
        int currentRow = startRow + rowOffset;
        int currentCol = startColumn + colOffset;
        List<String> moves = new ArrayList<>();

        while (chessBoard.isValidCell(currentRow, currentCol)) {
            moves.add(chessBoard.getCell(currentRow, currentCol));
            currentRow += rowOffset;
            currentCol += colOffset;
        }

        return moves;
    }
}
