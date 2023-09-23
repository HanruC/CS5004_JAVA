package chess;

/**
 * Interface of chess piece.
 * Include methods for chess.
 */
public interface ChessPiece {
  
  /**
   * Get row method.
   * @return row
   */
  int getRow();
  
  /**
   * Get column method.
   * @return column
   */
  int getColumn();
  
  /**
   * Get color method.
   * @return color
   */
  Color getColor();
  
  /**
   * can kill method.
   * @param piece target chess
   * @return true or false
   */
  boolean canKill(ChessPiece piece);
  
  /**
   * canMove method.
   * @param row row
   * @param col col
   * @return true or false
   */
  boolean canMove(int row, int col);
  
  
}
