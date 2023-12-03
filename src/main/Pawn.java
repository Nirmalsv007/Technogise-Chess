package main;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece {

    public Pawn() {
        super(PieceType.PAWN);
    }

    private static final int FORWARD_ROW_OFFSET = 1;  // Assuming pawns move only in the forward direction

    @Override
    public List<String> getPossibleMoves(String currentCell, ChessBoard chessBoard) {
        List<String> moves = new ArrayList<>();

        int row = chessBoard.getCellRow(currentCell);
        int column = chessBoard.getCellColumn(currentCell);
        int forwardCell = row - FORWARD_ROW_OFFSET;

        if (chessBoard.isValidCell(forwardCell, column)) {
            moves.add(chessBoard.getCell(forwardCell, column));
        }

        return moves;
    }

}
