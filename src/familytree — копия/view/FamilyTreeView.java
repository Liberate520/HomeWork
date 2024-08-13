package familytree.view;

import java.util.Scanner;

public class FamilyTreeView implements IFamilyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayFamilyTree(String familyTree) {
        System.out.println("Family Tree: \n" + familyTree);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displaySortedTreeByAge(String sortedTree) {
        System.out.println("Sorted Tree By Age: \n" + sortedTree);
    }
    @Override
    public void displaySortedTreeByName(String sortedTree) {
        System.out.println("Sorted  By Name: \n" + sortedTree);
    }

    @Override
    public String getFilePath() {
        System.out.print("Enter file path: ");
        return scanner.nextLine();
    }
}
