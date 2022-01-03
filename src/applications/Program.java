package applications;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while(true) {
            try {
                UserInterface.clearScreen();
                UserInterface.printMatch(chessMatch, capturedPieces);
                System.out.println("");
                System.out.print("Source: ");
                ChessPosition source = UserInterface.readChessPosition(input);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UserInterface.clearScreen();
                UserInterface.printBoard(chessMatch.getPieces(), possibleMoves, chessMatch);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UserInterface.readChessPosition((input));

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }
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
