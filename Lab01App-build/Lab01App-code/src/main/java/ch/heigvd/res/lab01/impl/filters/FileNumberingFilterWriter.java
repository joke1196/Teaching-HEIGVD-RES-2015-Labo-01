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
      
     String[] sArray = str.split("\n");
      int i = 1;
      String m = new String();
     for(String s : sArray){
         m += i + "\t" + s;
         i = i + 1;
         System.out.println(m);
     }
      out.write(m);
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
    for(int i = 0; i < len; i++){
        if(cbuf[i] == '\n'){
            size+=2;
        }
    }
  }

  @Override
  public void write(int c) throws IOException {
   
  }

}
