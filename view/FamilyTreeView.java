package homeWork.view;

import java.util.Scanner;

public class FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayFamilyTree(String familyTreeInfo) {
        System.out.println("Семейное древо:");
        System.out.println(familyTreeInfo);
    }

    public void promptUserInput(String message) {
        System.out.println(message);
        scanner.nextLine();
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayMessage(String string) {
        System.out.println(string);
    }
}
