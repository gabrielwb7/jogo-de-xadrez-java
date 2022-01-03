package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString()
    {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position aux = new Position(0,0);

        //above
        aux.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //below
        aux.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //right
        aux.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //left
        aux.setValues(position.getRow() , position.getColumn() - 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //northwest
        aux.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //northeast
        aux.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //southwest
        aux.setValues(position.getRow() + 1 , position.getColumn() - 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //southeast
        aux.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        if(getMoveCount() == 0 && !chessMatch.isCheck()) {
            Position positionRookRight = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionRookRight)) {
                Position positionFirstRookRight = new Position(position.getRow(), position.getColumn() + 1);
                Position positionSecondRookRight = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().piece(positionFirstRookRight) == null && getBoard().piece(positionSecondRookRight) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            Position positionRookLeft = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionRookLeft)) {
                Position positionFirstRookLeft = new Position(position.getRow(), position.getColumn() - 1);
                Position positionSecondRookLeft = new Position(position.getRow(), position.getColumn() - 2);
                Position positionThirdRookLeft = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(positionFirstRookLeft) == null && getBoard().piece(positionSecondRookLeft) == null && getBoard().piece(positionThirdRookLeft) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece aux = (ChessPiece)getBoard().piece(position);
        return aux != null && aux instanceof Rook && aux.getColor() == getColor() && aux.getMoveCount() == 0;
    }

}
