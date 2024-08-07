package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code SetParent} предназначена для установки родителя для члена семьи.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code setParent} в {@code ConsoleUI} для установки родительских связей
 * для конкретного члена семьи.</p>
 */
public class SetParent extends Command {

    /**
     * Конструктор класса {@code SetParent}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66";
    }

    /**
     * Выполняет команду установки родителя, вызывая метод {@code setParent}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.setParent();
    }
}
