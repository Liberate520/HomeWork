
package view.commands;

import view.ConsoleUI;

    public class SortByBirthDate extends Command {
        public SortByBirthDate(ConsoleUI consoleUI) {
            super(consoleUI);
            description = "Отсортировать список по возрасту";
        }

        public void execute(){
            consoleUI.sortByBirthDate();
        }
    }
