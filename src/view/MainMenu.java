package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

   /*
              Пункты меню:
            1. Добавить человека --> (+)
            2. Отсортировать древо по имени --> (+)
            3. Отсортировать древо по возрасту --> (+)
            4. Вывести список древа --> (+)
            5. Завершить работу --> (+)
            6*. Добавить ребенка --> доделать
            7*. Добавить супруга --> доделать
            8*. Внести дату смерти --> доделать
            9*. Сохранить древо в файл --> доделать
            10*. Вывести сохраненный файл --> доделать
            10*. Поиск сведений о родителях (отдельно по матери и отцу) --> доделать
            10*. Поиск сведений о детях --> доделать
             */


    public MainMenu(ConsoleUI consoleUI) {
        // формирование пунктов меню
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new Finish(consoleUI));
//        commands.add(new AddHuman(consoleUI));  // Добавить ребенка --> доделать
//        commands.add(new AddHuman(consoleUI)); // Добавить супруга --> доделать
//        commands.add(new AddHuman(consoleUI)); // Внести дату смерти --> доделать
//        commands.add(new AddHuman(consoleUI)); // Сохранить древо в файл --> доделать
//        commands.add(new AddHuman(consoleUI)); // Вывести сохраненный файл --> доделать
//        commands.add(new AddHuman(consoleUI)); // Поиск сведений о родителях (отдельно по матери и отцу) --> доделать
//        commands.add(new AddHuman(consoleUI)); // Поиск сведений о детях --> доделать
    }

    public String menuItems() {
        // формирование внешнего вида и автоматической нумерации пунктов меню
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню приложения:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        // метод выбора пунктов меню
        if (choice <= sizeMenu() && choice > 0) {
            Command command = commands.get(choice - 1); // получение команды
//        command.execute();
            command.execute();
        } else {
            System.out.println("Некорректный ввод! Попробуйте ещё раз.");
        }
    }


    public int sizeMenu() {
        return commands.size(); // метод вычисления количества пунктов меню
    }



}
