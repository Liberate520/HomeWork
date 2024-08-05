import Model.FamilyTree.FamilyTree;
import Model.Service.HumanService;
import Model.Writer.Writer;
import Model.Writer.FileHandler;
import View.ConsoleUI;
import View.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }
}
