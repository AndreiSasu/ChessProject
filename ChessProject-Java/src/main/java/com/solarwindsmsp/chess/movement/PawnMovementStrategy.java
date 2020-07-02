package com.solarwindsmsp.chess.movement;

import com.solarwindsmsp.chess.MovementType;
import com.solarwindsmsp.chess.Pawn;
import com.solarwindsmsp.chess.PieceColor;

public class PawnMovementStrategy implements MovementStrategy {

    private Pawn pawn;

    public PawnMovementStrategy(Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public void move(MovementType movementType, int xCoordinate, int yCoordinate) {
        if(isValidMovement(movementType, xCoordinate, yCoordinate)) {
            this.pawn.setYCoordinate(yCoordinate);
            this.pawn.setXCoordinate(xCoordinate);
        }
    }

    private boolean isValidMovement(final MovementType movementType, final int xCoordinate, final int yCoordinate) {

        boolean validType = MovementType.MOVE.equals(movementType) || MovementType.CAPTURE.equals(movementType);
        boolean sameX = xCoordinate == this.pawn.getXCoordinate();

        if (sameX && validType){
            return PieceColor.BLACK.equals(this.pawn.getPieceColor()) ?
                    // for black pawn lower Y means forward since they move down
                    yCoordinate < this.pawn.getYCoordinate() :

                    // for white pawn higher Y means forward since they move up
                    yCoordinate > this.pawn.getYCoordinate();
        }

        return false;
    }
}
