package Model.WorkingWithFile;
import Model.TypeOfRelationship.TypeOfRelationship;
import java.io.IOException;

public interface FileProcessing {
    void save(TypeOfRelationship tree, String fileAddress) throws IOException;
    TypeOfRelationship read(String fileAddress) throws IOException, ClassNotFoundException;
}