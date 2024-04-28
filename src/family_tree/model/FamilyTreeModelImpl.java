package family_tree.model;

import family_tree.person.Person;
import family_tree.util.GenealogyTree;

import java.util.Map;

public class FamilyTreeModelImpl implements FamilyTreeModel {
    private GenealogyTree<Person> familyTree;

    public FamilyTreeModelImpl() {
        this.familyTree = new GenealogyTree<>();
    }

     public Map<Integer, Person> getFamilyTree() {
        // Логика получения семейного дерева и его преобразования в Map<Integer, Person>
        return null; // Замените на вашу логику
    }

    @Override
    public void addPerson(Person person) {
        familyTree.addElement(person.getId(), person);
    }

    @Override
    public void removePerson(int id) {
        familyTree.removeElement(id);
    }
}