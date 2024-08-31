package GB_Homework;

import GB_Homework.Model.Handler.FileHandler;
import GB_Homework.Model.Handler.Writable;
import GB_Homework.Model.Service.FamilyTreeService;
import GB_Homework.Model.Service.FileService;
import GB_Homework.Presenter.Presenter;
import GB_Homework.View.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        Writable fileHandler = new FileHandler();

        FamilyTreeService familyTreeService = new FamilyTreeService();

        FileService fileService = new FileService(fileHandler);

        Presenter presenter = new Presenter(familyTreeService, fileService);

        ConsoleUI consoleUI = new ConsoleUI(presenter);

        consoleUI.start();
    }
}