package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.placement.PlacementStrategy;

/**
 * All chess pieces have:
 *  - coordinates on the board
 *  - need some rules to place them on the board (PlacementStrategy)
 *  - have a board relationship
 *  - have a Color
 *  - are movable
 *
 *  therefore it makes sense to keep all the below as part of the contract
 */
public interface Piece {
    PlacementStrategy getPlacementStrategy();
    int getXCoordinate();
    void setXCoordinate(int value);
    int getYCoordinate();
    void setYCoordinate(int value);
    ChessBoard getChessBoard();
    void setChessBoard(ChessBoard chessBoard);
    PieceColor getPieceColor();
    void move(MovementType movementType, int newX, int newY);
}
