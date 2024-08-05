package family_tree.model.service;
import family_tree.model.comporators.HumanComparatorByAge;
import family_tree.model.comporators.HumanComparatorByName;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.humanTree.HumanTree;
import family_tree.model.humanTree.ItemHumanTree;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private final HumanTree<Human> humans;
    private List<Human> children;

    public Service() {
        humans = new HumanTree<>();
    }


    public void addHuman (String name, String surname, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, List<Human> children) {
        Human human = new Human(name, surname, dob, dod, gender, father, mother, children);
        humans.addHuman(human);
    }

    public String getInfoAboutParents(Human human) {
        StringBuilder sb = new StringBuilder();
        if (human.getFather() == null && human.getMother() == null) {
            sb.append(human.getName() + " has no information about parents.");
            return sb.toString();
        } else if (human.getFather() == null) {
            sb.append(human.getName() + " has no information about father.");
            sb.append("Mother of " + human.getName() + " " + human.getSurname() + ":\n" + human.getMother() + "\n");
            return sb.toString();
        } else if (human.getMother() == null) {
            sb.append("Father of " + human.getName() + " " + human.getSurname() + ":\n" + human.getFather() + "\n");
            sb.append(human.getName() + " has no information about mother.");
            return sb.toString();
        }
        sb.append("Parents of " + human.getName() + ":\n");
        sb.append("\n");
        sb.append("Father:\n" + human.getFather() + "\n");
        sb.append("Mother:\n" + human.getMother() + "\n");
        return sb.toString();
    }

    public String getInfoAboutChildren(Human human) {
        StringBuilder sb = new StringBuilder();
        List<Human> children = human.getChildren();
        if (human.getChildren().isEmpty()) {
            sb.append(human.getName() + " doesn`t hava a child.");
            return sb.toString();
        }
        sb.append("Children of " + human.getName() + ": \n");
        int i = 1;
        for (ItemHumanTree child : children) {
            sb.append(i + " child: ");
            sb.append(child + "\n");
            i++;
        }
        return sb.toString();
    }

    public HumanTree<Human> getHumans() {
        return humans;
    }

    public void sortByName () {
        System.out.println("Отсортированный по имени список: \n");
        humans.sortByName();
    }

    public void sortByAge() {
        System.out.println("Отсортированный по возрасту список: \n");
        humans.sortByAge();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public String humansInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Полное генеалогическое дерево: \n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


}
