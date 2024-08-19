package family_tree.writer;
import java.io.*;


public interface Writer {
    boolean save(Serializable serializable);
    Object read();

}
