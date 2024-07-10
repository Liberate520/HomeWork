package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.humen.Gender;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        String genderStr = view.promptForString("Введите пол человека (мужской/женский):");
        Gender gender = genderStr.equalsIgnoreCase("мужской") ? Gender.Male : Gender.Female;

        LocalDate birthDate = promptForDate("Введите дату рождения человека (yyyy-MM-dd):");

        LocalDate deathDate = null;
        boolean hasDeathDate = view.promptForBoolean("Есть ли у человека дата смерти? (да/нет)");
        if (hasDeathDate) {
            deathDate = promptForDate("Введите дату смерти человека (yyyy-MM-dd):");
        }

        TreeNodeImpl father = null;
        TreeNodeImpl mother = null;

//        boolean hasParents = view.promptForBoolean("Есть ли у человека отец и мать? (да/нет)");
//        if (hasParents) {
//            String fatherName = view.promptForString("Введите имя отца:");
//            father = familyTreeService.getByName(fatherName);
//            if (father == null) {
//                father = new TreeNodeImpl(fatherName, null, null, null);
//                familyTreeService.addHuman(father);
//            }
//
//            String motherName = view.promptForString("Введите имя матери:");
//            mother = familyTreeService.getByName(motherName);
//            if (mother == null) {
//                mother = new TreeNodeImpl(motherName, null, null, null);
//                familyTreeService.addHuman(mother);
//            }
//        }

        TreeNodeImpl human = new TreeNodeImpl(name, gender, birthDate, deathDate, father, mother);
        boolean added = familyTreeService.addHuman(human);

        if (added) {
            view.displayMessage("Человек успешно добавлен в семейное дерево.");
        } else {
            view.displayMessage("Ошибка при добавлении человека в семейное дерево.");
        }
    }

    private LocalDate promptForDate(String message) {
        while (true) {
            try {
                String dateStr = view.promptForString(message);
                return LocalDate.parse(dateStr);
            } catch (DateTimeParseException e) {
                view.displayMessage("Ошибка: Введите дату в формате yyyy-MM-dd.");
            }
        }
    }
}
