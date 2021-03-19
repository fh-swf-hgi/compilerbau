package Kap2.Kap2_2.sourcecodeprovider;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.EOFException;

public class FileProvider implements SourceCodeProvider {
	private int line, column;
	private int savedLine, savedColumn;
	private int mLine, mColumn;
	private int savedMLine, savedMColumn;

        private int offset = 1;

	private RandomAccessFile file; 
	private long markedPos, currentPos;

        private boolean isReset = false;

	public FileProvider(String filename) {
		try {
		   file = new RandomAccessFile(filename,"r");
		} catch (IOException e) {
		   System.out.println(e);	
                   file = null;;
		}
	}
	public char getNextChar() {
		if (file == null || currentPos<0) return EOF;
		try {
		  	// for unicode-files:
                        // char c = file.readChar(); offset = 2;
                        // for ascii files
                        char c = (char) file.readByte();
			currentPos+=offset;
                        if (!isReset) {
			  savedLine = line;
			  savedColumn = column++;
			  if (c=='\n' || c=='\r') {
				line++;
				column = 0;
                          }
			}
                        else isReset = false;
			return c;
		} catch (EOFException e) {
			currentPos = -2;
			return EOF;
		} catch (IOException e) {
			currentPos = -2;
			return EOF;
		}
	}
  	public void setMarker() {
		if (currentPos<0) return;
		savedMLine = savedLine;
		savedMColumn = savedColumn;
		mLine = line;
		mColumn = column;
		markedPos = currentPos-offset;
	}
 	public void resetToMarker() {
		if (file == null || currentPos<0) return;
		savedLine = savedMLine;
		savedColumn = savedMColumn;
		line = mLine;
		column = mColumn;
		currentPos = markedPos;
                isReset = true;
		try {
			file.seek(currentPos);
		} catch (IOException e) {
			file = null;
		}
	}
 	public SourcePosition getCurrentPosition() {
		return new SourcePosition(savedLine, savedColumn);
	}
    	public SourcePosition getNextPosition() {
		return new SourcePosition(line, column);
	}
	public void close() {
		try {
			if (file!=null) file.close();
		} catch (IOException e) {
			file = null;
		}
	}
}
