package family_tree.model.service;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.humanTree.HumanTree;
import family_tree.model.humanTree.ItemHumanTree;
import family_tree.model.writer.FileHandler;
import family_tree.model.writer.Writer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Service implements Serializable {
    private HumanTree<Human> humans;
    Writer writer = new FileHandler();
    public Service() {
        humans = new HumanTree<>();
    }

    public void addHumanNullNodes(String name, String surname, LocalDate dob, LocalDate dod, Gender gender) {
        Human human = new Human(name, surname, dob, dod, gender, null, null);
        humans.addHuman(human);
    }

    public String getNameByID (int id) {
        Human human = getHumanById(id);
        return human.getName();
    }

    public String getInfoAboutParents(int id) {
        return humans.getInfoAboutParents(getHumanById(id));
    }

    public String getInfoAboutChildren(int id) {
        return humans.getInfoAboutChildren(getHumanById(id));
    }

    public HumanTree<Human> getHumans() {
        return humans;
    }

    public void sortByName () {
        humans.sortByName();
    }

    public void sortByAge() {
        humans.sortByAge();
    }

    public Human getHumanById(int id) {
        return humans.getHumanById(id);
    }

    public void addChild(int idParent, int idChild) {
        Human parent = getHumanById(idParent);
        Human child = getHumanById(idChild);
        if (parent.getGender() == Gender.male) {
            child.setFather(parent);
        }
        else {child.setMother(parent);}
        parent.addChild(child);
    }

    public String humansInfo(String message) {
        if (humans.size() == 0 && humans == null) {
            return "Список пуст";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(message).append("\n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void save(HumanTree humanTree) {
        writer.save(humanTree);
    }

    public HumanTree read() {
        HumanTree humanTree = (HumanTree) writer.read();
        return humanTree;
    }

    public void clear() {
        writer.clear();
        humans = null;
    }

    public void setHumans () {
        humans = read();
    }
}
