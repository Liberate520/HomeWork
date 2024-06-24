
package view.commands;

import view.ConsoleUI;

    public class SortByBirthDay extends Command {
        public SortByBirthDay(ConsoleUI consoleUI) {
            super(consoleUI);
            description = "Отсортировать список по возрасту";
        }

        public void execute(){
            consoleUI.sortByBirthDate();
        }
    }
