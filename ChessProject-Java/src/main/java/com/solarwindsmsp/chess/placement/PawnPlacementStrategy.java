package com.solarwindsmsp.chess.placement;

import com.solarwindsmsp.chess.ChessBoard;
import com.solarwindsmsp.chess.Pawn;

public class PawnPlacementStrategy implements PlacementStrategy {

    private static final int MAX_PAWNS_OF_SAME_COLOR = 8;
    private final Pawn pawn;

    public PawnPlacementStrategy(final Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public boolean isValidPlacement(final ChessBoard chessBoard, final int xCoordinate, final int yCoordinate) {
        return chessBoard.countByPieceAndColor(this.pawn) < MAX_PAWNS_OF_SAME_COLOR
                && chessBoard.isSlotAvailable(xCoordinate, yCoordinate);
    }
}
