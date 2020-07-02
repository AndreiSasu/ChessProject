package com.solarwindsmsp.chess.movement;

import com.solarwindsmsp.chess.MovementType;

public interface MovementStrategy {
    void move(final MovementType movementType, final int xCoordinate, final int yCoordinate);
}
