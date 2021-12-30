package applications;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        UserInterface.printBoard(chessMatch.getPieces());

        while(true) {
            try {
                UserInterface.clearScreen();
                UserInterface.printBoard(chessMatch.getPieces());
                System.out.println("");
                System.out.print("Source: ");
                ChessPosition source = UserInterface.readChessPosition(input);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UserInterface.readChessPosition((input));

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException chessException) {
                System.out.println(chessException.getMessage());
                input.nextLine();
            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println(inputMismatchException.getMessage());
                input.nextLine();
            }
        }
    }
}
