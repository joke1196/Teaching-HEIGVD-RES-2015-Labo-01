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

  @Override
  public void write(String str, int off, int len) throws IOException {
     
      out.write();
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    int size = 2;
    for(int i = 0; i < len; i++){
        if(cbuf[i] == '\n'){
            size+=2;
        }
    }
    char[] s = new char[size+len];
    char j = 0;
    for(int i = 2; i < len; i++){
        s[0] = ++j;
        s[1] = '\t';
        if(cbuf[i] == '\n'){
            
        }
    }
    out.write(s);
  }

  @Override
  public void write(int c) throws IOException {
      out.write(c);
  }

}
