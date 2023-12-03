package test;

import main.ChessBoard;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ChessBoardTest {

    private ChessBoard chessBoard;

    @BeforeEach
    public void setup() {
        chessBoard = new ChessBoard();
    }

    @Test
    public void shouldInitialiseEmptyChessBoard() {
        assertEquals("A8", chessBoard.getCell(0, 0));
        assertEquals("E5", chessBoard.getCell(3, 4));
        assertEquals("H1", chessBoard.getCell(7, 7));
    }

    @Test
    public void shouldCheckIfCellIsValid() {
        assertTrue(chessBoard.isValidCell(0, 0));
        assertTrue(chessBoard.isValidCell(7, 7));

        assertFalse(chessBoard.isValidCell(-1, 0));
        assertFalse(chessBoard.isValidCell(8, 0));
        assertFalse(chessBoard.isValidCell(0, -1));
        assertFalse(chessBoard.isValidCell(0, 8));
    }

    @Test
    public void shouldReturnCellRowForGivenValidChessCell() {
        assertEquals(0, chessBoard.getCellRow("A8"));
        assertEquals(7, chessBoard.getCellRow("H1"));
    }

    @Test
    public void shouldReturnChessColumnForGivenValidChessCell() {
        assertEquals(0, chessBoard.getCellColumn("A8"));
        assertEquals(7, chessBoard.getCellColumn("H1"));
    }

    @Test
    public void shouldReturnMinusOneForGivenInvalidChessCell() {
        assertEquals(-1, chessBoard.getCellRow("Z5"));
        assertEquals(-1, chessBoard.getCellRow("A0"));

        assertEquals(0, chessBoard.getCellColumn("A8"));
        assertEquals(7, chessBoard.getCellColumn("H1"));
    }

    @Test
    public void shouldReturnProperChessCellFromGivenRowAndColumn() {
        assertEquals("A8", chessBoard.getCell(0, 0));
        assertEquals("H1", chessBoard.getCell(7, 7));

        assertEquals("", chessBoard.getCell(-1, 0));
        assertEquals("", chessBoard.getCell(8, 0));
        assertEquals("", chessBoard.getCell(0, -1));
        assertEquals("", chessBoard.getCell(0, 8));
    }

}