import java.io.Serializable;
import java.util.List;
public class GenealogyTree implements java.io.Serializable {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    public List<Person> getAllChildrenOfPerson(String name) {
        return findPersonByName(name).getAllChildren();
    }

    private Person findPersonByName(String name) {
        // Your implementation goes here
        return root;
    }
}
