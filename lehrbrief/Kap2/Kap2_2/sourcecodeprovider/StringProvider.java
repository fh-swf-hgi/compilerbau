package Kap2.Kap2_2.sourcecodeprovider;

public class StringProvider implements SourceCodeProvider {
  private String contents;
  private int currentPosition;
  private int markerPosition;
  
  public StringProvider(String contents) { 
	this.contents = contents;
  }
  public char getNextChar() {
	if (currentPosition >= contents.length()) { currentPosition++; return EOF; }
	else return contents.charAt(currentPosition++);
  }
  public void setMarker() {
      markerPosition = currentPosition-1;
  }
  public void resetToMarker() {
	 currentPosition = markerPosition;
  }
  public SourcePosition getCurrentPosition() {
    return new SourcePosition(0, currentPosition-1);
  }
  public SourcePosition getNextPosition() {
    return new SourcePosition(0, currentPosition);
  }
  public void close() {}
}
