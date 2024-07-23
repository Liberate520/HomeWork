package view.commands;

import view.ConsoleView;

public class RegisterUser extends Command {
    public RegisterUser(ConsoleView consoleView) {
        super("Регистрация пользователя", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().registerUser();
    }
}
