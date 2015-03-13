package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
     //throw new UnsupportedOperationException("The student has not implemented this method yet.");
//     if(rootDirectory.length() != 0){
     if (rootDirectory == null) return;
     vistor.visit(rootDirectory);
      explorePrivate(rootDirectory, vistor);
      
  }
  
  private void explorePrivate(File rootDirectory, IFileVisitor vistor) { 
        if(rootDirectory.listFiles()!= null){
        for(File f: rootDirectory.listFiles()){
            if(f.isFile()){
                vistor.visit(f);
            }

        }
        for(File f: rootDirectory.listFiles()){
            if(f.isDirectory()){
                vistor.visit(f);
                explorePrivate(f, vistor);
            }

        }
        }
//     }
      
  }

}
