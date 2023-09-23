package chess;

/**
 * Rook class that extends abstract class.
 */
public class Rook extends AbstractClass {
  
  /**
   * This is the rook constructor.
   * @param row row
   * @param col col
   * @param color color
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  /**
   * This is the canMove method includes moving rules.
   * @param row row
   * @param col col
   * @return true or false
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.col) {
      return false;
    } else return (row == this.row || col == this.col);
  }
  
  /**
   * This is the canKill method includes killing rules.
   * @param piece target chess
   * @return true or false.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceCol = piece.getColumn();
    
    return ((this.row == pieceRow || this.col == pieceCol) && piece.getColor() != this.color);
  } // also adding color diff.
}
