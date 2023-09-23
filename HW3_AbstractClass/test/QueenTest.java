import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.ChessPiece;
import chess.Color;
import chess.Queen;
import org.junit.Test;

/**
 * This is the test class for queen.
 */
public class QueenTest {
  
  /**
   * This is the test for getter method.
   */
  @Test
  public void testGetter() {
    Queen queen = new Queen(5,5, Color.BLACK);
    assertEquals(5, queen.getRow());
    assertEquals(5, queen.getColumn());
    assertEquals(Color.BLACK, queen.getColor());
  }
  
  /**
   * This is the test for canMove method.
   */
  @Test
  public void canMoveTest() {
    Queen queen = new Queen(1, 1, Color.BLACK);
    assertTrue(queen.canMove(4, 1));
    assertTrue(queen.canMove(1, 5));
    assertTrue(queen.canMove(2,2));
    assertFalse(queen.canMove(3, 2));
  }
  
  /**
   * This is the test for canKill method.
   */
  @Test
  public void canKillTest() {
    Queen queen = new Queen(2, 2, Color.BLACK);
    ChessPiece piece = new Queen(3, 2, Color.WHITE);
    ChessPiece piece2 = new Queen(2, 4, Color.WHITE);
    ChessPiece piece3 = new Queen(4, 4, Color.WHITE);
    assertTrue(queen.canKill(piece));
    assertTrue(queen.canKill(piece2));
    assertTrue(queen.canKill(piece3));
    ChessPiece piece4 = new Queen(3, 5, Color.WHITE);
    ChessPiece piece5 = new Queen(3, 3, Color.BLACK);
    assertFalse(queen.canKill(piece4));
    assertFalse(queen.canKill(piece5));
  }
  
  /**
   * This is the test for invalid position.
   */
  @Test (expected = IllegalArgumentException.class)
  public void InvalidPos() {
    Queen queen = new Queen(0, 8, Color.WHITE);
  }
}
