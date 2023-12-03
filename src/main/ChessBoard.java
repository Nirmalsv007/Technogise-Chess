package main;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ChessBoard {

    private final String[][] board;

    public ChessBoard() {
        board = new String[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char columnLabel = (char) ('A' + j);
                int rowLabel = 8 - i;
                board[i][j] = String.valueOf(columnLabel) + rowLabel;
            }
        }
    }

    public boolean isValidCell(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }

    public int getCellRow(String cell) {
        return IntStream.range(0, 8)
                .filter(index -> Arrays.asList(board[index]).contains(cell))
                .findFirst()
                .orElse(-1);
    }

    public int getCellColumn(String cell) {
        int row = getCellRow(cell);
        return row != -1 ?
                IntStream.range(0, 8)
                        .filter(j -> board[row][j].equals(cell))
                        .findFirst()
                        .orElse(-1) :
                -1;
    }

    public String getCell(int row, int column) {
        return isValidCell(row, column) ? board[row][column] : "";
    }

}
