package ru.gb2.family_tree7;


import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.presenter.FamilyTreePresenter;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView() {
            @Override
            public void showFamilyMembers(List<Human> members) {
                for (Human member : members) {
                    System.out.println(member);
                }
            }

            @Override
            public void showFamilyMembers(boolean add) {
                if (add) {
                    System.out.println("Член семьи успешно добавлен.");
                }
            }
        };

        FamilyTreePresenter presenter = new FamilyTreePresenter(view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Добавить члена семьи");
            System.out.println("2 - Показать членов семьи");
            System.out.println("0 - Выход");
            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.nextLine(); // очищаем ввод
                continue; // переходим к следующей итерации
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Удаляем новую строку после ввода числа

            switch (choice) {
                case 1:
                    presenter.addMember(); // Добавление нового члена семьи
                    break;
                case 2:
                    presenter.showMembers(); // Показать членов семьи
                    break;
                case 0:
                    scanner.close(); // Закрыть сканер перед выходом
                    return; // Завершить программу
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
    }
}

//        FamilyTreePresenter presenter = new FamilyTreePresenter((FamilyTreeView) view, familyTree);
//
//        Human ivanIvanov = new Human(1, "Ivan Ivanov", LocalDate.of(1980, 1, 1), Gender.MALE, "Отец");
//        Human ianaIvanova = new Human(2, "Iana Ivanova", LocalDate.of(1985, 5, 15), Gender.FEMALE, "Мать");
//        Human child = new Human(3, "Igor Ivanov", LocalDate.of(2010, 3, 20), Gender.MALE, " Ребенок");
//
//        familyTree.add(ivanIvanov);
//        familyTree.add(ianaIvanova);
//        familyTree.add(child);
//
//        ivanIvanov.addChild(child);
//        ianaIvanova.addChild(child);
//        child.addParent(ivanIvanov);
//        child.addParent(ianaIvanova);
//
//        presenter.displayFamilyTree();
//    }

