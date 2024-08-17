package writer;

import familytree.FamilyTree;
import person.Person;

public interface TreeStorage<T extends Person> {
    void save(FamilyTree<T> familyTree, String fileName);
    FamilyTree<T> load(String fileName);
}
