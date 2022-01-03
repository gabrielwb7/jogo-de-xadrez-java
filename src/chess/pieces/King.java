package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString()
    {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
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

        return mat;
    }
}
