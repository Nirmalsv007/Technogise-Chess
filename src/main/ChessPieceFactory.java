package main;

public class ChessPieceFactory {

    public static ChessPiece createChessPiece(PieceType pieceType) {
        return switch (pieceType) {
            case PAWN -> new Pawn();
            case KING -> new King();
            case QUEEN -> new Queen();
        };
    }
}
