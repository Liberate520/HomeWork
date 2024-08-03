package Filehendler;

import java.io.Serializable;

public interface Writer{
    boolean save(Serializable serializable);
    Object read();
   
}