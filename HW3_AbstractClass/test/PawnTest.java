import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.ChessPiece;
import chess.Color;
import chess.Pawn;
import org.junit.Test;

/**
 * This is the pawn test class.
 */
public class PawnTest {
  
  /**
   * This is to test invalid position for pawn.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidPosValid() {
    Pawn pawn = new Pawn(0, 2, Color.WHITE);
    Pawn pawn2 = new Pawn(7, 3, Color.BLACK);
  }
  
  /**
   * This is to test the getter method.
   */
  @Test
  public void testGetter() {
    Pawn pawn = new Pawn(2,3, Color.WHITE);
    assertEquals(2, pawn.getRow());
    assertEquals(3, pawn.getColumn());
    assertEquals(Color.WHITE, pawn.getColor());
  }
  
  /**
   * This is the test for canMove method.
   */
  @Test
  public void testCanMove() {
    Pawn pawn = new Pawn(2,4, Color.WHITE);
    Pawn pawn2 = new Pawn(5, 4, Color.BLACK);
    assertTrue(pawn2.canMove(4, 4));
    assertTrue(pawn.canMove(3, 4));
    assertFalse(pawn.canMove(4,4));
    Pawn pawnInitialBlack = new Pawn(6, 4, Color.BLACK);
    Pawn pawnInitialWhite = new Pawn(1, 3, Color.WHITE);
    assertTrue(pawnInitialWhite.canMove(3,3));
    assertTrue(pawnInitialWhite.canMove(2, 3));
    assertTrue(pawnInitialBlack.canMove(5, 4));
    assertTrue(pawnInitialBlack.canMove(4, 4));
  }
  
  /**
   * This is the test for canKill method.
   */
  @Test
  public void testCanKill() {
    Pawn pawn = new Pawn(2,3, Color.WHITE);
    ChessPiece piece = new Pawn(3, 4, Color.BLACK);
    ChessPiece piece2 = new Pawn(3, 5, Color.BLACK);
    ChessPiece piece22 = new Pawn(3,3, Color.BLACK);
    assertTrue(pawn.canKill(piece));
    assertFalse(pawn.canKill(piece2));
    assertFalse(pawn.canKill((piece22)));
    Pawn pawn2 = new Pawn(5, 5, Color.BLACK);
    ChessPiece piece3 = new Pawn(4,4, Color.WHITE);
    ChessPiece piece4 = new Pawn(3,3, Color.WHITE);
    assertTrue(pawn2.canKill(piece3));
    assertFalse(pawn2.canKill(piece4));
  }
}
