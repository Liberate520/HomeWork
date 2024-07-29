package ru.gb2.family_tree7.view;

import ru.gb2.family_tree7.model.human.Human;

import java.util.List;

public abstract class ConsoleUI implements View {

    @Override
    public void showFamilyMembers(List<Human> members) {
        for (Human member : members) {
            System.out.println("Name: " + member.getName() +
                    ", Birth Date: " + member.getBirthDate() +
                    ", Age: " + member.getAge() +
                    ", Gender: " + member.getGender());
        }
    }
}