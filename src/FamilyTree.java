import java.util.List;

public class FamilyTree {
    private Researcher researcher;

    public FamilyTree(Researcher researcher) {
        this.researcher = researcher;
    }

    public List<Person> getAllDescendants(Person person) {
        return researcher.getDescendants(person);
    }
}
