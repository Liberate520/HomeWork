package View.Commands;

import View.Command;

import Presenter.Presenter;
import View.Command;
import View.MainMenu;

    public class SortByAmountOfChildren extends Command {

        public SortByAmountOfChildren() {
            super("Сортировать по количеству детей");
        }

        @Override
        public void execute() {
            presenter.SortByAmountOfChildren();
        }
    }
