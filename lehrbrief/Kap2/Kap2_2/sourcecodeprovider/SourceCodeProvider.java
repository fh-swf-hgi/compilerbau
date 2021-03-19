package Kap2.Kap2_2.sourcecodeprovider;

public interface  SourceCodeProvider {
	public static final char EOF = 0;

	char getNextChar();
  	void setMarker();
 	void resetToMarker();
 	SourcePosition getCurrentPosition();
 	SourcePosition getNextPosition();
	void close();
}
