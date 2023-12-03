package test;

import main.ChessBoard;
import main.King;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {

    private King king;

    private ChessBoard chessBoard;

    @BeforeEach
    public void setup() {
        chessBoard = new ChessBoard();
        king = new King();
    }

    @Test
    void shouldReturnAllPossibleMovesForKingWhenInMiddleOfBoard() {
        List<String> moves = king.getPossibleMoves("D4", chessBoard);

        assertEquals(List.of("C3", "C4", "C5", "D3", "D5", "E3", "E4", "E5"), moves);
    }

    @Test
    void shouldReturnPossibleMovesOfKingWhenInEdge() {
        List<String> kingMovesForA1 = king.getPossibleMoves("A1", chessBoard);
        List<String> kingMovesForH5 = king.getPossibleMoves("H5", chessBoard);
        List<String> kingMovesForF8 = king.getPossibleMoves("F8", chessBoard);
        List<String> kingMovesForC1 = king.getPossibleMoves("C1", chessBoard);

        assertEquals(List.of("A2", "B1", "B2"), kingMovesForA1);
        assertEquals(List.of("G4", "G5", "G6", "H4", "H6"), kingMovesForH5);
        assertEquals(List.of("E7", "E8", "F7", "G7", "G8"), kingMovesForF8);
        assertEquals(List.of("B1", "B2", "C2", "D1", "D2"), kingMovesForC1);
    }

}