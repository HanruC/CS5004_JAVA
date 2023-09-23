package chess;

/**
 * Public class for bishop including constructor, move and kill rules.
 */
public class Bishop extends AbstractClass {
  /**
   * Constructor of bishop.
   * @param row row of bishop.
   * @param col column of bishop.
   * @param color color of bishop.
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  /**
   * canMove method implementing the rule of bishop movement.
   * @param row row of bishop desire to move.
   * @param col col of bishop desire to move.
   * @return return true of false.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (row == this.row && col == this.col) {
      return false;
    } else {
      return Math.abs(row - this.row) == Math.abs(col - this.col);
    }
  }
  
  /**
   * Killing rules for bishop.
   * @param piece target piece.
   * @return true or false.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int rowMoved = Math.abs(this.row - piece.getRow());
    int colMoved = Math.abs(this.col - piece.getColumn());
    return (rowMoved == colMoved && piece.getColor() != this.color);
  }
}
