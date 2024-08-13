package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanComparatorByDOB;
import family_tree.model.human.HumanComparatorByName;
import family_tree.model.writer.FileHendler;

import java.time.LocalDate;
import java.util.Iterator;

public class Service {
    private FamilyTree<Human> familyTree;

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, String fatherID, String matherID) {
        Human human = new Human();
        human.setName(name);
        human.setDob(dob);
        human.setDod(dod);
        human.setGender(gender);
        if (!fatherID.isEmpty()) {
            human.setFather(familyTree.getHumans().get(Integer.parseInt(fatherID) - 1));
        }
        if (!matherID.isEmpty()) {
            human.setFather(familyTree.getHumans().get(Integer.parseInt(matherID) - 1));
        }
        familyTree.addHuman(human);

    }

    public String getHumansInfo(int sort) {
        StringBuilder stringBuilder = new StringBuilder();
        if (sort == 1) {
            stringBuilder.append("Список людей древа без сортировки:\n");
        } else if (sort == 2) {
            stringBuilder.append("Список людей древа сортировка по имени:\n");
        } else if (sort == 3) {
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
        familyTree.getHumans().sort(new HumanComparatorByName<>());
    }

    public void sortByDOB() {
        familyTree.getHumans().sort(new HumanComparatorByDOB<>());
    }


    public void saveTree() {
        FileHendler fh = new FileHendler();
        fh.save(familyTree);
    }

    public void readTree() {
        FileHendler fh = new FileHendler();
        familyTree = (FamilyTree<Human>) fh.read();
    }
}
