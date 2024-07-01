package seminar2.model.Service;

import seminar2.model.Human.Gender;
import seminar2.model.Human.Human;
import seminar2.model.Tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private Human human;

    public Service() {
        tree = new FamilyTree<>();
        human = new Human(null, null, null, null, null, null,
                null, null);
    }

    public void addRelative(String name, String surname, Gender valueOf, LocalDate dateOfBirth) {
        Human human = new Human(name, surname, valueOf, dateOfBirth);
        tree.add(human);
        tree.getInfo();
    }

    public void getByNameSurname(String name, String surname) {
        tree.getByNameSurname(name, surname);
    }


    public void getByOneFamily(String surname) {
        tree.getByOneFamily(surname);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sorBySurname() {
        tree.sortBySurname();
    }

    public void sortByAge() {
        tree.getInfoSortByAge();
    }

    public String getInfo(){
        return tree.getInfo();
    }
}
