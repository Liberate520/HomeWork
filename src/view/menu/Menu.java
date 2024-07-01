package view.menu;

import view.command.Command;

import java.util.List;

public abstract class Menu {
    protected List<Command> commands;
    protected String menuName;

    /**
     * Создает StringBuilder добавляет в него название меню  и список команд из передаваемого меню,
     * а также визуальный разделитьль из *
     * возвращает результат преобразованный в строку
     * @return String
     */
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------\n");
        stringBuilder.append(menuName);
        stringBuilder.append("\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append("------------------------");
        return stringBuilder.toString();
    }

    /**
     * Получает int и выполняет метод execute в команде из массива по этому индексу
     * @param choice
     */
    public void execute (int choice) {
        commands.get(choice).execute();
    }

    /**
     * ВОзвращает список команд commands
     * @return
     */
    public List<Command> getCommands() {
        return commands;
    }
}
