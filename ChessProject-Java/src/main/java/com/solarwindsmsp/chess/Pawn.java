package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.movement.MovementStrategy;
import com.solarwindsmsp.chess.movement.PawnMovementStrategy;
import com.solarwindsmsp.chess.placement.PawnPlacementStrategy;
import com.solarwindsmsp.chess.placement.PlacementStrategy;

public class Pawn implements Piece {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private final PieceColor pieceColor;

    protected final MovementStrategy movementStrategy;
    protected final PlacementStrategy placementStrategy;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.movementStrategy = new PawnMovementStrategy(this);
        this.placementStrategy = new PawnPlacementStrategy(this);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void move(MovementType movementType, int newX, int newY) {
        this.movementStrategy.move(movementType, newX, newY);
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }

    @Override
    public PlacementStrategy getPlacementStrategy() {
        return this.placementStrategy;
    }

    @Override
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    @Override
    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    @Override
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    @Override
    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }
}
