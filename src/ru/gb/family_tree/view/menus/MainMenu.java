package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.*;

/**
 * Главное меню {@code MainMenu} представляет собой меню с основными командами для работы с приложением.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Menu} и инициализирует список команд,
 * доступных в главном меню. Команды включают добавление члена семьи, установку даты смерти,
 * установку родителя, установку супруга, чтение и запись данных, а также завершение работы приложения.</p>
 */
public class MainMenu extends Menu {

    /**
     * Конструктор класса {@code MainMenu}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetAboutFamily(consoleUI));
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
