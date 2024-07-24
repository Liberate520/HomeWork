package Family_tree.writer;

import java.io.IOException;

public interface Writer {
    void read() throws IOException, ClassNotFoundException; 
    boolean write(Object object) throws IOException;
}