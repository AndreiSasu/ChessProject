package com.solarwindsmsp.chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn blackPawn;
    private Pawn whitePawn;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.blackPawn = new Pawn(PieceColor.BLACK);
        this.whitePawn = new Pawn(PieceColor.WHITE);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.add(blackPawn, 6, 3);
        assertEquals(6, blackPawn.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.add(blackPawn, 6, 3);
        assertEquals(3, blackPawn.getYCoordinate());
    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.add(blackPawn, 6, 3);
        blackPawn.move(MovementType.MOVE, 7, 3);
        assertEquals(6, blackPawn.getXCoordinate());
        assertEquals(3, blackPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.add(blackPawn, 6, 3);
        blackPawn.move(MovementType.MOVE, 4, 3);
        assertEquals(6, blackPawn.getXCoordinate());
        assertEquals(3, blackPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_BlackPawn() {
        chessBoard.add(blackPawn, 6, 3);
        blackPawn.move(MovementType.MOVE, 6, 2);
        assertEquals(6, blackPawn.getXCoordinate());
        assertEquals(2, blackPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_ILLegalCoordinates_Backwards_BlackPawn_DoesNotUpdate() {
        chessBoard.add(blackPawn, 6, 3);
        blackPawn.move(MovementType.MOVE, 6, 4); // for a black pawn higher y means backwards
        assertEquals(6, blackPawn.getXCoordinate());
        assertEquals(3, blackPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_WhitePawn() {
        chessBoard.add(whitePawn, 1, 1);
        whitePawn.move(MovementType.MOVE, 1, 2);
        assertEquals(1, whitePawn.getXCoordinate());
        assertEquals(2, whitePawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_ILLegalCoordinates_Backwards_WhitePawn_DoesNotUpdate() {
        chessBoard.add(whitePawn, 1, 1);
        whitePawn.move(MovementType.MOVE, 1, 0);
        assertEquals(1, whitePawn.getXCoordinate());
        assertEquals(1, whitePawn.getYCoordinate());
    }

}