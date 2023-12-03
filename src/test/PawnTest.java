package test;

import main.ChessBoard;
import main.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    private ChessBoard chessBoard;

    private Pawn pawn;

    @BeforeEach
    public void setup() {
        chessBoard = new ChessBoard();
        pawn = new Pawn();
    }

    @Test
    void shouldReturnPossibleMovesForPawnInMiddleOfBoard() {
        List<String> moves = pawn.getPossibleMoves("D4", chessBoard);

        assertEquals(List.of("D5"), moves);
    }

    @Test
    void shouldReturnPossibleMovesForPawnAtCornerOfBoard() {
        assertEquals(List.of("H3"), pawn.getPossibleMoves("H2", chessBoard));
        assertEquals(List.of(), pawn.getPossibleMoves("A8", chessBoard));
    }

}