package chess;

/**
 * This is a abstract class that also implements chessPiece.
 */
public abstract class AbstractClass implements ChessPiece {
  protected int row;
  protected int col;
  protected Color color;
  
  /**
   * This is an abstract class constructor without boundary restriction.
   * @param row row
   * @param col col
   * @param color color
   */
  public AbstractClass(int row, int col, Color color) {
    this.row = row;
    this.col = col;
    this.color = color;
  }
  
  /**
   * This is the helper function for all classes besides pawn.
   */
  protected void helper() {
    int lowBoundary = 0;
    int highBoundary = 7;
    if (row < lowBoundary || row > highBoundary || col < lowBoundary || col > highBoundary) {
      throw new IllegalArgumentException("Invalid Position.");
    }
  }
  
  /**
   * This is the helper function for pawn constructor.
   */
  protected void pawnHelper() {
    int whiteBoundary = 0;
    int blackBoundary = 7;
    int lowBoundary = 1;
    int highBoundary = 6;
    
    if (color == Color.WHITE && row == whiteBoundary) {
      throw new IllegalArgumentException("White pawns in wrong row.");
    }
    if (color == Color.BLACK && row == blackBoundary) {
      throw new IllegalArgumentException("Black pawns in wrong row");
    }
    if (row < lowBoundary || row > highBoundary || col < whiteBoundary || col > blackBoundary) {
      throw new IllegalArgumentException("Invalid Position.");
    }
  }
  
  /**
   * Get the row.
   * @return this.row
   */
  @Override
  public int getRow() {
    return this.row;
  }
  
  /**
   * Get the column.
   * @return this.column
   */
  @Override
  public int getColumn() {
    return this.col;
  }
  
  /**
   * Get the color.
   * @return this.color
   */
  @Override
  public Color getColor() {
    return this.color;
  }
  
  /**
   * canMove method in abstract class. Different chess has different move rules.
   * @param row row
   * @param col col
   * @return true or false
   */
  @Override
  public abstract boolean canMove(int row, int col);
  
  /**
   * canKill method in abstract class. Different chess has different kill rules.
   * @param piece target chess
   * @return true or false
   */
  @Override
  public abstract boolean canKill(ChessPiece piece);
}
