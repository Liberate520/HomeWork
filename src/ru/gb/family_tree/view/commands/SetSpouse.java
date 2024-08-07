package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code SetSpouse} предназначена для установки супруга(и) для члена семьи.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code setSpouse} в {@code ConsoleUI} для установления супружеских связей
 * для конкретных членов семьи.</p>
 */
public class SetSpouse extends Command {

    /**
     * Конструктор класса {@code SetSpouse}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у) \uD83D\uDC6B";
    }

    /**
     * Выполняет команду установки супруга(и), вызывая метод {@code setSpouse}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}
