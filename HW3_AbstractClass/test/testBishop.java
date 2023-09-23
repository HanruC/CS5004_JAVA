import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import org.junit.Test;

/**
 * This is a test class for chessPiece.
 */
public class testBishop {
  /**
   * TestBishop for canMove and getRow, getColumn, getColor.
   */
  @Test
  public void testBishop() {
    Bishop bishop = new Bishop(5, 4, Color.WHITE);
    assertEquals(5, bishop.getRow());
    assertEquals(4, bishop.getColumn());
    assertEquals(Color.WHITE, bishop.getColor());
    
    Bishop bishop2 = new Bishop(2, 2, Color.WHITE);
    assertTrue(bishop2.canMove(3, 3));
    assertTrue(bishop2.canMove(5, 5));
    assertFalse(bishop2.canMove(2, 2));
    assertFalse(bishop2.canMove(4, 6));
    
    ChessPiece piece = new Bishop(4,4, Color.BLACK);
    assertTrue(bishop2.canKill(piece));
    assertFalse(bishop.canKill(piece));
  }
  
  /**
   * This is the test for invalid position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidPos() {
    Bishop bishop = new Bishop(1, 10, Color.WHITE);
  }
}