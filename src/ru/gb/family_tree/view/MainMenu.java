package ru.gb.family_tree.view;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<String> menuItems;
    private ConsoleUI consoleUI;

    public MainMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        menuItems = new ArrayList<>();
        menuItems.add("Добавить человека");
        menuItems.add("Получить информацию о людях");
        menuItems.add("Отсортировать по имени");
        menuItems.add("Отсортировать по возрасту");
        menuItems.add("Сохранить данные");
        menuItems.add("Загрузить данные");
        menuItems.add("Закончить работу");
    }

    public void execute(int numCommand) {
        switch (numCommand) {
            case 1:
                consoleUI.addHuman();
                break;
            case 2:
                consoleUI.getHumanListInfo();
                break;
            case 3:
                consoleUI.sortByName();
                break;
            case 4:
                consoleUI.sortByAge();
                break;
            case 5:
                consoleUI.saveData();
                break;
            case 6:
                consoleUI.loadData();
                break;
            case 7:
                consoleUI.finish();
                break;
            default:
                System.out.println("Неизвестная команда. Попробуйте снова.");
                break;
        }
    }

    public int getSize() {
        return menuItems.size();
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            sb.append(i + 1).append(". ").append(menuItems.get(i)).append("\n");
        }
        return sb.toString();
    }
}
