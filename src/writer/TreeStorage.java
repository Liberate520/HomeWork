package writer;

import familytree.FamilyTree;
import person.Person;

public interface TreeStorage<T extends Person> {
    void save(FamilyTree<T> tree, String fileName);
    FamilyTree<T> load(String fileName);
}
