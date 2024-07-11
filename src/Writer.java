import java.io.IOException;

public interface Writer {

    void save(String fileName, FamilyTree tree) throws IOException;
    FamilyTree load(String fileName) throws IOException, ClassNotFoundException;
}
