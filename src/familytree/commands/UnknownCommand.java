package familytree.commands;

import familytree.ui.UserInterface;

public class UnknownCommand implements Command {
        private final UserInterface userInterface;

    public UnknownCommand(UserInterface userInterface) {
            this.userInterface = userInterface;
        }

        @Override
        public boolean execute() {
            userInterface.displayMessage("Неизвестная команда. Попробуйте снова.");
            return false;
        }
    }