import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.ChessPiece;
import chess.Color;
import chess.Knight;
import org.junit.Test;

/**
 * This is the test class for knight.
 */
public class testKnight {
  
  /**
   * This is the test for getter method.
   */
  @Test
  public void testGetter() {
    Knight knight = new Knight(3,4, Color.BLACK);
    assertEquals(3, knight.getRow());
    assertEquals(4, knight.getColumn());
    assertEquals(Color.BLACK, knight.getColor());
  }
  
  /**
   * This is the test for canMove method.
   */
  @Test
  public void testCanMove() {
    Knight knight = new Knight(4,5,Color.WHITE);
    assertTrue(knight.canMove(6, 6));
    assertTrue(knight.canMove(5, 7));
    assertFalse(knight.canMove(5, 5));
  }
  
  /**
   * This is the test for canKill method.
   */
  @Test
  public void canKillTest() {
    Knight knight = new Knight(3,3, Color.BLACK);
    ChessPiece piece = new Knight(5, 4, Color.WHITE);
    assertTrue(knight.canKill(piece));
    ChessPiece piece2 = new Knight(4, 5, Color.WHITE);
    assertTrue(knight.canKill(piece2));
    ChessPiece piece3 = new Knight(4, 4, Color.WHITE);
    ChessPiece piece4 = new Knight(4, 5, Color.BLACK);
    assertFalse(knight.canKill(piece3));
    assertFalse(knight.canKill(piece4));
  }
  
  /**
   * This is the test for invalid position.
   */
  @Test (expected = IllegalArgumentException.class)
  public void InvalidPos() {
    Knight knight = new Knight(1, 9, Color.BLACK);
  }
}
