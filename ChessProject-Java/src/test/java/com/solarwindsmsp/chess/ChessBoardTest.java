package com.solarwindsmsp.chess;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends TestCase {

    private ChessBoard testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new ChessBoard();
    }

    @Test
    public void testHas_MaxBoardWidth_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 0);
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, 5);
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(11, 5);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 9);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(11, 0);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, -1);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void Avoids_Duplicate_Positioning() {
        Pawn firstPawn = new Pawn(PieceColor.BLACK);
        Pawn secondPawn = new Pawn(PieceColor.BLACK);
        testSubject.add(firstPawn, 6, 3);
        testSubject.add(secondPawn, 6, 3);
        assertEquals(6, firstPawn.getXCoordinate());
        assertEquals(3, firstPawn.getYCoordinate());
        assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, secondPawn.getXCoordinate());
        assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, secondPawn.getYCoordinate());
    }

    // y coordinate means up / down, x coordinate means left / right
    @Test
    public void testLimits_The_Number_Of_Pawns()
    {
        for (int i = 0; i < 10; i++)
        {
            Pawn pawn = new Pawn(PieceColor.BLACK);
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            testSubject.add(pawn, i % ChessBoard.MAX_BOARD_WIDTH, 5);
            if (row < 1)
            {
                assertEquals(5 + row, pawn.getYCoordinate());
                assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getXCoordinate());
                assertNotNull(pawn.getChessBoard());
            }
            else
            {
                assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, pawn.getXCoordinate());
                Assert.assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, pawn.getYCoordinate());
                assertNull(pawn.getChessBoard());
            }
        }
    }

    @Test
    public void testIsLegalBoardPosition_7x7() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(7, 7);
        assertTrue(isValidPosition);
    }

    @Test
    public void testIllegalBoardPosition_8x8() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(8, 8);
        assertFalse(isValidPosition);
    }

    @Test
    public void testMax8PawnsOfSameColor() {
        for(int i = 0; i < 9; i++) {
            final Pawn pawn = new Pawn(PieceColor.BLACK);
            testSubject.add(pawn, i % ChessBoard.MAX_BOARD_WIDTH, 6);

            if(i < 8) {
                assertEquals(6, pawn.getYCoordinate());
                assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getXCoordinate());
                assertNotNull(pawn.getChessBoard());
            } else {
                assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, pawn.getXCoordinate());
                Assert.assertEquals(ChessBoard.COORDINATES_OUT_OF_BOARD, pawn.getYCoordinate());
                assertNull(pawn.getChessBoard());
            }
        }
    }
}