package com.solarwindsmsp.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    // chess boards are 8x8 pieces https://www.chess.com/article/view/chess-board-dimensions#basics
    // but piece coordinates start from 0 - 7
    public static final int MAX_BOARD_WIDTH = 8;
    public static final int MAX_BOARD_HEIGHT = 8;
    public static final int COORDINATES_OUT_OF_BOARD = -1;

    private Piece[][] pieces;
    private Map<String, Integer> piecesIndex = new HashMap<>();

    public ChessBoard() {
        pieces = new Piece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void add(Piece piece, int xCoordinate, int yCoordinate) {
        if(isSlotAvailable(xCoordinate, yCoordinate) && piece.getPlacementStrategy().isValidPlacement(this, xCoordinate, yCoordinate))  {
            pieces[xCoordinate][yCoordinate] = piece;
            piece.setChessBoard(this);
            piece.setXCoordinate(xCoordinate);
            piece.setYCoordinate(yCoordinate);
            incrementCounterForPiece(piece);
        } else {
            piece.setXCoordinate(COORDINATES_OUT_OF_BOARD);
            piece.setYCoordinate(COORDINATES_OUT_OF_BOARD);
        }
    }

    public int countByPieceAndColor(final Piece piece) {
        return this.piecesIndex.getOrDefault(getCompositeKeyForPiece(piece), 0);
    }

    public boolean isSlotAvailable(final int xCoordinate, final int yCoordinate) {
        return this.isLegalBoardPosition(xCoordinate, yCoordinate) && null == pieces[xCoordinate][yCoordinate];
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH) && (yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT);
    }

    private void incrementCounterForPiece(final Piece piece) {
        final String compositeKey = getCompositeKeyForPiece(piece);
        Integer currentCount = piecesIndex.getOrDefault(compositeKey, 0);
        piecesIndex.put(compositeKey, ++currentCount);
    }

    private String getCompositeKeyForPiece(final Piece piece) {
        return piece.getClass().getName() + piece.getPieceColor().name();
    }
}
