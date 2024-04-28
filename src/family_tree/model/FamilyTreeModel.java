package family_tree.model;

import family_tree.person.Person;
import family_tree.util.GenealogyTree;

import java.util.Map;


public interface FamilyTreeModel {
    Map<Integer, Person> getFamilyTree();

    void addPerson(Person person);

    void removePerson(int id);
}
