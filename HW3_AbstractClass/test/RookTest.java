import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.ChessPiece;
import chess.Color;
import chess.Rook;
import org.junit.Test;

/**
 * This is the test class for rook.
 */
public class RookTest {
  
  /**
   * This is the test for getter method.
   */
  @Test
  public void testGetter() {
    Rook rook = new Rook(2,4, Color.WHITE);
    assertEquals(2, rook.getRow());
    assertEquals(4, rook.getColumn());
    assertEquals(Color.WHITE, rook.getColor());
  }
  
  /**
   * This is the test for canMove method.
   */
  @Test
  public void testCanMove() {
    Rook rook = new Rook(2, 4, Color.WHITE);
    assertTrue(rook.canMove(4,4));
    assertTrue(rook.canMove(2,6));
    assertFalse(rook.canMove(3, 5));
  }
  
  /**
   * This is the test for canKill method.
   */
  @Test
  public void testCanKill() {
    Rook rook = new Rook(2, 2, Color.WHITE);
    ChessPiece piece = new Rook(5, 2, Color.BLACK);
    ChessPiece piece2 = new Rook(2, 6, Color.BLACK);
    ChessPiece piece3 = new Rook(3, 4, Color.BLACK);
    assertTrue(rook.canKill(piece));
    assertTrue(rook.canKill(piece2));
    assertFalse(rook.canKill(piece3));
    ChessPiece piece4 = new Rook(3,2, Color.WHITE);
    assertFalse(rook.canKill(piece4));
  }
  
  /**
   * This is the test to test invalid position.
   */
  @Test (expected = IllegalArgumentException.class)
  public void InvalidPos() {
    Rook rook = new Rook(1, 9, Color.BLACK);
  }
}
