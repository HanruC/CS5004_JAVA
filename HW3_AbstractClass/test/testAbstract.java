import static org.junit.Assert.assertEquals;

import chess.AbstractClass;
import chess.ChessPiece;
import chess.Color;
import org.junit.Test;

/**
 * This is the test class for abstract class.
 */
public class testAbstract {
  
  /**
   * This is the test for constructor.
   */
  @Test
  public void AbstractTest() {
    AbstractClass abstractClass = new AbstractClass(2, 2, Color.WHITE) {
  
      /**
       * Override.
       * @param row row
       * @param col col
       * @return true or false
       */
      @Override
      public boolean canMove(int row, int col) {
        return false;
      }
  
      /**
       * Override.
       * @param piece target chess
       * @return true or false
       */
      @Override
      public boolean canKill(ChessPiece piece) {
        return false;
      }
    };
    assertEquals(2, abstractClass.getRow());
    assertEquals(2, abstractClass.getColumn());
    assertEquals(Color.WHITE, abstractClass.getColor());
  }
}
