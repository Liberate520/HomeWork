package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code AddMember} предназначена для добавления нового члена семьи через пользовательский интерфейс.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code addMember} в {@code ConsoleUI} для добавления нового члена семьи.</p>
 */
public class AddMember extends Command {

    /**
     * Конструктор класса {@code AddMember}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи \uD83D\uDC64";
    }

    /**
     * Выполняет команду добавления нового члена семьи, вызывая соответствующий метод в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
