package view.commands;

// Применяем DIP: Создаем интерфейс CommandInterface.
public interface CommandInterface {
    String getDescription();

    void execute();
}
