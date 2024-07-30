package view;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu {
    private ConsoleUI ui;
    private final Map<Integer, MenuItem> menuItems;

    public MainMenu(ConsoleUI ui) {
        this.ui = ui;
        menuItems = new LinkedHashMap<>();
        menuItems.put(1, new MenuItem("Показать всех членов семьи", ui::displayHumanList));
        menuItems.put(2, new MenuItem("Добавить нового члена семьи", ui::addHuman));
        menuItems.put(3, new MenuItem("Сортировать членов семьи по имени", ui::sortByName));
        menuItems.put(4, new MenuItem("Сортировать членов семьи по дате рождения", ui::sortByBirthDate));
        menuItems.put(5, new MenuItem("Найти члена семьи по имени", ui::findMemberByName));
        menuItems.put(6, new MenuItem("Найти членов семьи по году рождения", ui::findMembersByBirthYear));
        menuItems.put(7, new MenuItem("Сохранить дерево семьи", ui::saveFamilyTree));
        menuItems.put(8, new MenuItem("Загрузить дерево семьи", ui::loadFamilyTree));
        menuItems.put(9, new MenuItem("Выйти", () -> {}));
    }

    public String menu() {
        StringBuilder menuBuilder = new StringBuilder();
        for (Map.Entry<Integer, MenuItem> entry : menuItems.entrySet()) {
            menuBuilder.append(entry.getKey())
                    .append(". ")
                    .append(entry.getValue().getDescription())
                    .append("\n");
        }
        return menuBuilder.toString();
    }

    public void execute(int choice) {
        MenuItem menuItem = menuItems.get(choice);
        if (menuItem != null) {
            menuItem.getAction().run();
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
        }
    }
}
