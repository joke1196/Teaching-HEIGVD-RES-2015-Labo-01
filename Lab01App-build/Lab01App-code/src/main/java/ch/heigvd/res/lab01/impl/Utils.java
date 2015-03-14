package ch.heigvd.res.lab01.impl;

import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String[] array = new String[2];
    array[1] = "";
    if(lines.contains("\r\n")){
        
        int index = lines.indexOf("\r\n");
        array[0] = lines.substring(0, index + "\r\n".length());
        if(index + 1 != lines.length()){
            array[1] = lines.substring(index + "\r\n".length());
        }
        return array;
    }else if(lines.contains("\n")){
        int index = lines.indexOf("\n");
        array[0] = lines.substring(0, index + "\n".length());
        if(index + 1 != lines.length()){
            array[1] = lines.substring(index + "\n".length());
        }
        
        return array;
    }else{
        int index = lines.indexOf("\r");
        array[0] = lines.substring(0, index + "\r".length());
        if(index + 1 != lines.length()){
            array[1] = lines.substring(index + "\r".length());
        }
    
        return array;
    
    }
    

    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

}
