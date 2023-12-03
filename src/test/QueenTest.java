package test;

import main.ChessBoard;
import main.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {

    private ChessBoard chessBoard;

    private Queen queen;

    @BeforeEach
    public void setup() {
        chessBoard = new ChessBoard();
        queen = new Queen();
    }

    @Test
    void shouldReturnPossibleMovesForQueenInMiddleOfBoard() {
        List<String> moves = queen.getPossibleMoves("D4", chessBoard);

        assertEquals(List.of(
                "A1", "A4", "A7", "B2", "B4", "B6", "C3",
                "C4", "C5", "D1", "D2", "D3", "D5", "D6", "D7", "D8", "E3", "E4", "E5", "F2",
                "F4", "F6", "G1", "G4", "G7", "H4", "H8"), moves);
    }

    @Test
    void shouldReturnPossibleMovesForQueenInEdgeOfBoard() {
        List<String> movesForH8Position = queen.getPossibleMoves("H8", chessBoard);
        List<String> movesForA1Position = queen.getPossibleMoves("A1", chessBoard);

        assertEquals(List.of(
                "A1", "A8", "B2", "B8", "C3", "C8", "D4",
                "D8", "E5", "E8", "F6", "F8", "G7", "G8",
                "H1", "H2", "H3", "H4", "H5", "H6", "H7"
        ), movesForH8Position);
        assertEquals(List.of(
                "A2", "A3", "A4", "A5", "A6", "A7", "A8",
                "B1", "B2", "C1", "C3", "D1", "D4", "E1",
                "E5", "F1", "F6", "G1", "G7", "H1", "H8"
        ), movesForA1Position);
    }

}