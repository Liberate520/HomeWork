package humanTree;

import human.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanTree {
    private List<Human> humans; // ключ это родитель, значение это ребенок

    public HumanTree () {
        humans = new ArrayList<>();
    }


    public void addHuman (Human human) { //добавление человека
        humans.add(human);
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

    public String getInfoAboutChildren(Human human) { // информация о детях человека
        StringBuilder sb = new StringBuilder();
        if (human.getChildren().isEmpty()) {
            sb.append(human.getName() + " doesn`t hava a child.");
            return sb.toString();
        }

        sb.append("Children of " + human.getName() + ": \n");
        int i = 1;
        for (Human child : human.getChildren()) {
            sb.append(i + " child: ");
            sb.append(child + "\n");
            i++;
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Полное генеалогическое дерево: \n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
