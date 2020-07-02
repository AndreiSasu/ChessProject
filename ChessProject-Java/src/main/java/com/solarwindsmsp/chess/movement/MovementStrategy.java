package com.solarwindsmsp.chess.movement;

import com.solarwindsmsp.chess.MovementType;

public interface MovementStrategy {
    /**
     * Attempts to perform a movement of a Piece according to the strategy for that Piece
     * This method will do nothing if the Movement type or new coordinates are invalid for that Piece.
     *
     * @param movementType the {@link MovementType}
     * @param xCoordinate the new xCoordinate
     * @param yCoordinate the new yCoordinate
     */
    void move(final MovementType movementType, final int xCoordinate, final int yCoordinate);
}
