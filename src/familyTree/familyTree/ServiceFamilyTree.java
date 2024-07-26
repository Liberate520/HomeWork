package familyTree.familyTree;

import familyTree.FileHandler.FileHandler;
import familyTree.HumanBuilder.HumanBuilder;
import familyTree.human.Gender;
import familyTree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class ServiceFamilyTree {
    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;

    public ServiceFamilyTree() {
        familyTree = new FamilyTree();
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


    public void getFamilyTree() {
        System.out.println(familyTree.toString());
    }

    public String getfamilyTreeList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семейного двера: \n");

        for (Human human : familyTree) {
         stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public Human getHuman(long id) {
        return familyTree.getHuman(id);
    }

    public boolean saveFile(String fileName) {
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.setFileName(fileName);
            fileHandler.saveFile(familyTree);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean openFile(String fileName) {
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.setFileName(fileName);
            familyTree = (FamilyTree) fileHandler.openFile();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}
