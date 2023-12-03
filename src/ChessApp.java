import main.*;

import java.util.List;
import java.util.Scanner;

public class ChessApp {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the type of Chess Piece or 'done' to exit - ");
            String pieceTypeString = scanner.nextLine();

            if (pieceTypeString.equalsIgnoreCase("done")) {
                System.out.println("Cheers! Have a nice day :)");
                break;
            }

            try {
                PieceType pieceType = PieceType.valueOf(pieceTypeString.toUpperCase());
                System.out.println("Enter the position of the chess piece ");
                String position = scanner.nextLine();

                if (!isValidPosition(position)) {
                    System.out.println("Invalid position. Try again :(");
                    continue;
                }

                ChessPiece chessPiece = ChessPieceFactory.createChessPiece(pieceType);

                if (chessPiece == null) {
                    System.out.println("Invalid chess piece type.");
                } else {
                    List<String> possibleMoves = chessPiece.getPossibleMoves(position, board);
                    System.out.println("Here are the possible moves you can play: ");
                    possibleMoves.forEach(System.out::println);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again :(");
            }
        }

        scanner.close();
    }

    private static boolean isValidPosition(String position) {
        if (position.length() != 2) {
            return false;
        }

        char columnChar = position.charAt(0);
        char rowChar = position.charAt(1);

        if (!(columnChar >= 'A' && columnChar <= 'H')) {
            return false;
        }

        return rowChar >= '1' && rowChar <= '8';
    }

}