package chess;

/**
 * King class that extends abstract class.
 */
public class King extends AbstractClass {
  
  /**
   * King constructor.
   * @param row row
   * @param col col
   * @param color color
   */
  public King(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  /**
   * canMove method for king includes moving rules.
   * @param row row
   * @param col col
   * @return true or false
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.col) {
      return false;
    } else {
      return Math.abs(this.row - row) <= 1 && Math.abs(this.col - col) <= 1;
    } // Only one move in any direction.
  }
  
  /**
   * canKill method for king, including killing rules.
   * @param piece target chess
   * @return true or false
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceCol = piece.getColumn();
    int pieceRowDiff = Math.abs(this.row - pieceRow);
    int pieceColDiff = Math.abs(this.col - pieceCol);
    
    return (pieceRowDiff <= 1 && pieceColDiff <= 1 && piece.getColor() != this.color);
    //only one step and the color should be different.
  }
}
