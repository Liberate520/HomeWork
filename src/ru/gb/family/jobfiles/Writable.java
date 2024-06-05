package ru.gb.family.jobfiles;

import java.io.Serializable;

public interface Writable  {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
    boolean chekFile(String filePath);
}
