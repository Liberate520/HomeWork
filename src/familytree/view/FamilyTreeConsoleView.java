package familytree.view;

import familytree.model.Human;

import java.util.List;

public class FamilyTreeConsoleView implements FamilyTreeView {

    @Override
    public void displayHumanDetails(Human human) {
        System.out.print(human.getName() + ", Born: " + human.getBirthDate());
        if (human.isAlive()) {
            System.out.println(", Age: " + human.getAge());
        } else {
            System.out.println(", Died: " + human.getDeathDate() + ", Age: " + human.getAge());
        }
        List<Human> parents = human.getParents();
        if (!parents.isEmpty()) {
            System.out.print("Parents: ");
            for (Human parent : parents) {
                System.out.print(parent.getName() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayHumanList(List<Human> humans) {
        for (Human human : humans) {
            displayHumanDetails(human);
        }
    }
}