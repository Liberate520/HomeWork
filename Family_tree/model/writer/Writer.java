package Family_tree.model.writer;

// import java.io.IOException;
// import java.io.Serializable;
import Family_tree.model.family_tree.FamilyTree;;

public interface Writer {
    Object read(String path); 
    void save(String filename, FamilyTree tree);
}