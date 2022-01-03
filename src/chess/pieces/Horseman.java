package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horseman extends ChessPiece {
    public Horseman(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "H";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position aux = new Position(0,0);

        aux.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 2 , position.getColumn() + 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(aux) && canMove(aux)) {
            mat[aux.getRow()][aux.getColumn()] = true;
        }
        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

}
