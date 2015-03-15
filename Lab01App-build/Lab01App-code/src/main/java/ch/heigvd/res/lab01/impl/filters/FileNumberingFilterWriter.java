package ch.heigvd.res.lab01.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

    private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());

    public FileNumberingFilterWriter(Writer out) {
        super(out);
    }

    private int lineNumber = 0;
    private int macOsChar;

    @Override
    public void write(String str, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(str.charAt(i));
        }

    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

        for (int i = off; i < off + len; i++) {
            write(cbuf[i]);
        }
    }

    @Override
    public void write(int c) throws IOException {

        if (lineNumber == 0) {
            lineNumber = lineNumber + 1;
            printintToChar();
            super.write('\t');
            super.write(c);
        } else {
            if (c == '\n') {
                lineNumber = lineNumber + 1;
                super.write(c);
                printintToChar();
                super.write('\t');
            } else if (macOsChar == '\r' && c != '\n') { //if it's only a \r for line return
                lineNumber++;
                printintToChar();
                super.write('\t');
                super.write(c); 
            } else {
                super.write(c);
                
            }
            macOsChar = c;
        }
    }

    public void printintToChar() throws IOException {
        char[] array = String.valueOf(lineNumber).toCharArray();
        for (int i = 0; i < array.length; i++) {
            super.write((int) array[i]);
        }

    }

}
