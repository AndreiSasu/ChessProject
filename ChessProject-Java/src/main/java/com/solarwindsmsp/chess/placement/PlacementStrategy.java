package com.solarwindsmsp.chess.placement;

import com.solarwindsmsp.chess.ChessBoard;

public interface PlacementStrategy {
    /**
     * Verifies if the attempted coordinates are valid initial placement for the Piece
     * on the ChessBoard
     * @param chessBoard the ChessBoard instance
     * @param xCoordinate the x coordinate ( left /right )
     * @param yCoordinate the y coordinate ( up / down )
     * @return whether the placement is valid
     */
    boolean isValidPlacement(final ChessBoard chessBoard, final int xCoordinate, final int yCoordinate);
}
