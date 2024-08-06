package src.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.View.Actions.Actions;
import src.View.Actions.AddChild;
import src.View.Actions.AddHuman;
import src.View.Actions.AddParent;
import src.View.Actions.Finish;
import src.View.Actions.Load;
import src.View.Actions.PrintByName;
import src.View.Actions.PrintTree;
import src.View.Actions.Save;
import src.View.Actions.SortByBirthday;
import src.View.Actions.SortByChildren;
import src.View.Actions.SortByName;

public class MainMenu {
    private List<Actions> actions;

    public MainMenu(ConsoleUI consoleUI) throws SecurityException, IOException{
        actions = new ArrayList<>();
        actions.add(new AddHuman(consoleUI));
        actions.add(new PrintTree(consoleUI));
        actions.add(new PrintByName(consoleUI));
        actions.add(new AddChild(consoleUI));
        actions.add(new AddParent(consoleUI));
        actions.add(new SortByName(consoleUI));
        actions.add(new SortByBirthday(consoleUI));
        actions.add(new SortByChildren(consoleUI));
        actions.add(new Save(consoleUI));
        actions.add(new Load(consoleUI));
        actions.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие:").append("\n");
        for (int i = 0; i < actions.size(); i++) {
            sb.append(i + 1);
            sb.append(" - ");
            sb.append(actions.get(i).getDescription());
            sb.append("\n");
        }
        // sb.append("1 - Создать новое семейное древо").append("\n");
        // sb.append("2 - Получить всю информацию членов семьи").append("\n");
        // sb.append("3 - Найти информацию члена семьи по имени").append("\n");
        // sb.append("4 - Добавить детей").append("\n");
        // sb.append("5 - Добавить родителей").append("\n");
        // sb.append("6 - Отсортировать членов семьи по имени в алфавитном порядке").append("\n");
        // sb.append("7 - Отсортировать членов семьи по дате рождения").append("\n");
        // sb.append("8 - Отсортировать членов семьи по количеству детей").append("\n");
        // sb.append("9 - Сохранить дерево в файл").append("\n");
        // sb.append("0 - Загрузить дерево из файла").append("\n");
        // sb.append("exit - Выход").append("\n");
        return sb.toString();
    }

    public void run(int choice) throws ClassNotFoundException, IOException{
        Actions action = actions.get(choice - 1);
        action.run();
    }
}
