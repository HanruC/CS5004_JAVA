package chess;

/**
 * Public class for knight extends abstract class.
 */
public class Knight extends AbstractClass {
  /**
   * Knight constructor.
   * @param row row of knight.
   * @param col col of knight.
   * @param color color of knight.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  /**
   * Moving rules for knight.
   * @param row row desires to go.
   * @param col col desires to go.
   * @return true or false.
   */
  @Override
  public boolean canMove(int row, int col) {
    int rowDiff = Math.abs(this.row - row);
    int colDiff = Math.abs(this.col - col);
  
    if (row == this.row && col == this.col) {
      return false;
    } else {
      return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
  }
  
  /**
   * Killing rules for knight.
   * @param piece target piece.
   * @return true or false.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceCol = piece.getColumn();
    
    int rowDiff = Math.abs(this.row - pieceRow);
    int colDiff = Math.abs(this.col - pieceCol);
    
    return (((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1))
            && piece.getColor() != this.color);
  }
}
