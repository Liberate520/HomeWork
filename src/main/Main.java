package main;

import presenter.FamilyTreePresenter;
import presenter.TreePresenter;
import service.FamilyTreeService;
import storage.DataLoader;
import storage.DataSaver;
import storage.FileDataLoader;
import storage.FileDataSaver;
import view.ConsoleTreeView;
import view.TreeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataLoader dataLoader = new FileDataLoader();
        DataSaver dataSaver = new FileDataSaver();
        FamilyTreeService service = new FamilyTreeService(dataLoader, dataSaver);

        TreeView treeView = new ConsoleTreeView();
        TreePresenter presenter = new FamilyTreePresenter(treeView, service);

        treeView.setPresenter(presenter);

        CommandProcessor commandProcessor = new CommandProcessor(service);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (add/find/children/exit):");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.exit(0);
            }

            commandProcessor.tryExecute(command);
        }
    }
}









