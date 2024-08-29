package view;

import view.commands.CommandList;

public interface View extends CommandList {
    void printAnswer(String text);

    void start();
}
