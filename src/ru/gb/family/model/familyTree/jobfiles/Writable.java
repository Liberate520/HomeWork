package ru.gb.family.model.familyTree.jobfiles;

import java.io.Serializable;
import java.util.List;

public interface Writable  {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
    boolean chekFile(String filePath);
    boolean deleteFile(String filePath);
    List<String> getListSaveTree(String pathDir);

}
