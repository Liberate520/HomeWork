package re.zip.famely_tree.writer;

import java.io.Serializable;

public interface Writable{
    boolean saveToFile(Serializable serializable, String filePath);

    Object readFromFile(String filePath);

}
