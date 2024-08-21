package familyTree.model.familyTree;

import familyTree.model.FileHandler.Writer;
import familyTree.model.HumanBuilder.HumanBuilder;
import familyTree.model.FileHandler.FileHandler;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;


import java.time.LocalDate;
import java.util.List;

public class ServiceFamilyTree {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    public ServiceFamilyTree() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();

    }

    public void addHuman(String lastName, String firstname, String patronymic,
                         Gender gender, LocalDate dayBirth, LocalDate dayDeath,
                         Human father, Human mother, List<Human> children, String placeBorn) {

        Human human = humanBuilder
                .setLastName(lastName)
                .setFirstname(firstname)
                .setPatronymic(patronymic)
                .setGender(gender)
                .setDayBirth(dayBirth)
                .setDayDeath(dayDeath)
                .setFather(father)
                .setMother(mother)
                .setChildren(children)
                .setPlaceBorn(placeBorn)
                .build();
        familyTree.addHuman(human);
    }

    public void addHuman(String lastName, String firstname, String patronymic,
                         Gender gender) {
        Human human = humanBuilder
                .setLastName(lastName)
                .setFirstname(firstname)
                .setPatronymic(patronymic)
                .setGender(gender)
                .build();
        familyTree.addHuman(human);
    }

    public void addParent(int idHuman, int idParent) {
        if (idParent < familyTreeSize() && idHuman < familyTreeSize()) {
            Human human = familyTree.getHuman(idHuman);
            Human parent = familyTree.getHuman(idParent);

            human.addParent(parent);
            parent.addChild(human);
        }
    }

    public void addChild(int idHuman, int idChild) {
        if (idChild < familyTreeSize() && idHuman < familyTreeSize()) {
            Human human = familyTree.getHuman(idHuman);
            Human child = familyTree.getHuman(idChild);
            human.addChild(child);
            child.addParent(human);
        }
    }

    private int familyTreeSize() {
        int count = 0;
        for (Human human : familyTree) {
            count++;
        }
        return count;
    }

    public void getFamilyTree() {
        System.out.println(familyTree.toString());
    }

    public String getFamilyTreeList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семейного двера: \n");

        for (Human human : familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByID() {
        familyTree.sortByID();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public Human getHuman(long id) {
        return familyTree.getHuman(id);
    }

    public boolean saveFile(String fileName) {
        try {
            Writer fileHandler = new FileHandler();
            fileHandler.setFileName(fileName);
            fileHandler.saveFile(familyTree);
            return true;
        } catch (Exception ex) {
            System.out.println("Ошибка сохранения");
            return false;
        }
    }

    public boolean openFile(String fileName) {
        try {
            Writer fileHandler = new FileHandler();
            fileHandler.setFileName(fileName);
            familyTree = (FamilyTree) fileHandler.openFile();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void setMaxID() {
        long maxID = familyTree.findMaxID();
        humanBuilder.setMaxID(maxID);
    }
}
