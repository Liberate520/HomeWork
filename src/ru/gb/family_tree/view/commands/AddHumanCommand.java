package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class AddHumanCommand implements Command {
    private final FamilyTreeService<TreeNodeImpl> familyTreeService;
    private final View view;

    public AddHumanCommand(FamilyTreeService<TreeNodeImpl> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        String name = view.promptForString("Введите имя человека:");
        String gender = view.promptForString("Введите пол человека (мужской/женский):");
        int age = view.promptForInt("Введите возраст человека:");

        TreeNodeImpl father = null;
        TreeNodeImpl mother = null;

        boolean hasParents = view.promptForBoolean("Есть ли у человека отец и мать? (да/нет)");
        if (hasParents) {
            String fatherName = view.promptForString("Введите имя отца:");
            String motherName = view.promptForString("Введите имя матери:");
            father = new TreeNodeImpl(fatherName); // Исправлено на TreeNodeImpl
            mother = new TreeNodeImpl(motherName); // Исправлено на TreeNodeImpl
        }

        LocalDate birthDate = LocalDate.now().minusYears(age); // Предполагаем, что возраст приводится к дате рождения

        TreeNodeImpl human;

        if (hasParents) {
            human = new TreeNodeImpl(name, gender, birthDate, father, mother);
        } else {
            human = new TreeNodeImpl(name);
        }

        boolean added = familyTreeService.addHuman(human);

        if (added) {
            view.displayMessage("Человек успешно добавлен в семейное дерево.");
        } else {
            view.displayMessage("Ошибка при добавлении человека в семейное дерево.");
        }
    }
}
