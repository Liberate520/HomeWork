package family_tree.view;

import family_tree.presenter.Presenter;
import family_tree.view.actions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<Integer, MenuActions> actions;
    private List<String> categories;

//    public Map<Integer, MenuActions> getActions() {
//        return actions;
//    }

    public Menu() {
        categories= new ArrayList<>();
        actions = new HashMap<>();
        actions.put(0, new FinishAction());
        actions.put(1, new AddHumanAction());
        actions.put(2, new SortByAgeAction());
        actions.put(3, new SortByNameAction());
        actions.put(4, new AddChildAction());
        actions.put(5, new HumansInfoAction());
        actions.put(6, new GetInfoAboutChildren());
        actions.put(7, new GetInfoAboutParents());
    }

    public void displayMenu() {
        System.out.println("Выберите действие: ");
        menuBuilder(categories);
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + " " + categories.get(i));
        }
    }

    public void menuBuilder(List<String> lst) {
        categories.add("Закончить работу");
        categories.add("Добавить человека");
        categories.add("Отсортировать по возрасту");
        categories.add("Отсортировать по имени");
        categories.add("Определить человека как ребенка другого человека (по ID) :)");
        categories.add("Полный список людей");
        categories.add("Информация о детях человека (по ID)");
        categories.add("Информация о родителях человека (по ID)");

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
