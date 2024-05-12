import java.io.IOException;

public interface FileProcessing {
    void save(TypeOfRelationship tree, String fileAddress) throws IOException;
    void read(String fileAddress) throws IOException, ClassNotFoundException;
}