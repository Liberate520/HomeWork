package re.zip.famely_tree;

import re.zip.famely_tree.model.human.Human;
import re.zip.famely_tree.model.service.Service;
import re.zip.famely_tree.model.service.writer.FileHandler;
import re.zip.famely_tree.presenter.Presenter;
import re.zip.famely_tree.view.ConsoleUI;
import re.zip.famely_tree.view.InputOutput;
import re.zip.famely_tree.view.View;

public class Main {
    public static void main(String[] args) {
        InputOutput inputOutput = new InputOutput();
        View view = new ConsoleUI(inputOutput);
        view.start();
    }
}

