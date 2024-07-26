package view;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    private ConsoleUI ui;
    private Map<Integer, Runnable> menuItems;

    public MainMenu(ConsoleUI ui) {
        this.ui = ui;
        menuItems = new HashMap<>();
        menuItems.put(1, ui::displayHumanList);
        menuItems.put(2, ui::addHuman);
        menuItems.put(3, ui::sortByName);
        menuItems.put(4, ui::sortByBirthDate);
        menuItems.put(5, ui::findMemberByName);
        menuItems.put(6, ui::findMembersByBirthYear);
    }

    public String menu() {
        return "1. Показать всех членов семьи\n" +
                "2. Добавить нового члена семьи\n" +
                "3. Сортировать членов семьи по имени\n" +
                "4. Сортировать членов семьи по дате рождения\n" +
                "5. Найти члена семьи по имени\n" +
                "6. Найти членов семьи по году рождения\n" +
                "7. Выйти";
    }

    public void execute(int choice) {
        Runnable action = menuItems.get(choice);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
        }
    }
}
