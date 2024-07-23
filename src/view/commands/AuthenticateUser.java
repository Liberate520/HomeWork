package view.commands;

import view.ConsoleView;

public class AuthenticateUser extends Command {
    public AuthenticateUser(ConsoleView consoleView) {
        super("Аутентификация пользователя", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().authenticateUser();
    }
}
