package main;

import java.util.List;

public abstract class ChessPiece {

    private final PieceType chessPieceName;

    public ChessPiece(PieceType name) {
        this.chessPieceName = name;
    }

    public abstract List<String> getPossibleMoves(String currentCell, ChessBoard chessBoard);

}
