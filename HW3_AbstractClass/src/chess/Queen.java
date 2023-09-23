package chess;

/**
 * Public class Queen extends abstract class.
 */
public class Queen extends AbstractClass {
  /**
   * Constructor for Queen.
   * @param row row
   * @param col column
   * @param color color
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
    helper();
  }
  
  /**
   * canMove method for implementing moving rules.
   * @param row desired row.
   * @param col desired col.
   * @return true or false.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (this.row == row && this.col == col) {
      return false;
    } else return row == this.row || col == this.col
            || Math.abs(row - this.row) == Math.abs(col - this.col);
  }
  
  /**
   * Killing rules method.
   * @param piece target piece.
   * @return true or false.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceCol = piece.getColumn();
    int pieceRow = piece.getRow();
    Color pieceColor = piece.getColor();
    int colDiff = Math.abs(this.col - pieceCol);
    int rowDiff = Math.abs(this.row - pieceRow);
    
    return ((colDiff == rowDiff || this.row == pieceRow || this.col == pieceCol)
            && pieceColor != this.color); //In sequence: diagonally, horizontally, vertically.
  }
}