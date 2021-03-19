package Kap2.Kap2_2.sourcecodeprovider;

public class SourcePosition {
  private int line, column;
  public SourcePosition(int line, int column) {
	this.line = line;
	this.column = column;
  }
  public int getLine() { return line; }
  public int getColumn() { return column; }
  public String toString() { return line + " : " + column; }
}
