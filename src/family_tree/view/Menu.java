package family_tree.view;

import family_tree.presenter.Presenter;
import family_tree.view.actions.*;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuActions> actions;

    public Map<Integer, MenuActions> getActions() {
        return actions;
    }

    public Menu() {
        actions = new HashMap<>();
        actions.put(1, new AddHumanAction());
        actions.put(2, new SortByAgeAction());
        actions.put(3, new SortByNameAction());
        actions.put(4, new AddChildAction());
        actions.put(5, new HumansInfoAction());
        actions.put(6, new FinishAction());
    }

    public void displayMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Отсортировать по возрасту");
        System.out.println("3. Отсортировать по имени");
        System.out.println("4. Определить человека как ребенка другого человека :)");
        System.out.println("5. Полный список людей");
        System.out.println("5. Закончить работу");
    }

    public void performAction(int choice, Presenter presenter) {
        MenuActions action = actions.get(choice);
        if (action != null) {
            action.execute(presenter);
        } else {
            System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }




}
