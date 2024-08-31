package familytree.ui;

import java.util.HashMap;
import java.util.Map;

public class MenuProvider implements MenuProviderInterface {
    private final Map<String, String> menuItems = new HashMap<>();

    public MenuProvider() {
        initializeMenu();
    }

    private void initializeMenu() {
        menuItems.put("1", "Добавить члена семьи");
        menuItems.put("2", "Найти по имени");
        menuItems.put("3", "Добавить родительско-детскую связь");
        menuItems.put("4", "Вывести всех членов, отсортированных по фамилии и имени");
        menuItems.put("5", "Вывести всех членов, отсортированных по дате рождения");
        menuItems.put("6", "Сохранить дерево в файл");
        menuItems.put("7", "Загрузить дерево из файла");
        menuItems.put("0", "Выйти");
    }

    @Override
    public Map<String, String> getMenuItems() {
        return menuItems;
    }
}