package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;
import java.util.Iterator;

public class Service {
    private FamilyTree familyTree;
    private Human human;

    public Service() {
        familyTree = new FamilyTree();

        //human = new Human();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, String fatherID, String matherID) {
        human = new Human();
        human.setName(name);
        human.setDob(dob);
        human.setDod(dod);
        human.setGender(gender);
        if (!fatherID.equals("")) {
            human.setFather(familyTree.searchByHumanID(fatherID));
        }
        if (!matherID.equals("")) {
            human.setMather(familyTree.searchByHumanID(matherID));
        }
        familyTree.addHuman(human);
        System.out.println(getHumansInfo(1));
    }

    public String getHumansInfo(int sort) {
        StringBuilder stringBuilder = new StringBuilder();
        if (sort == 1){
            stringBuilder.append("Список людей древа без сортировки:\n");
        }
        else if (sort == 2) {
            stringBuilder.append("Список людей древа сортировка по имени:\n");
        }
        else if (sort == 3) {
            stringBuilder.append("Список людей древа сортировка по дате рождения:\n");
        }
        Iterator<Human> iterator = familyTree.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByDOB() {
        familyTree.sortByDOB();
    }


    public void searhHumansByName(String name) {
        if (familyTree.searchByHumanName(name) == null){
            System.out.println("Человек по имени " + name + " не найден в древе");
        }else {
            System.out.println("Результат поиска :");
            System.out.println(familyTree.searchByHumanName(name).toString());
        }
    }
}
