package writer;

import family_tree.FamilyTree;

import java.io.*;

public interface Writeble extends Serializable  {
    boolean save(Serializable serializable, String pathFile) ;
    Object read(String pathFile);
}
