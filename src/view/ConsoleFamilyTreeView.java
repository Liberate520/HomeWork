package view;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    @Override
    public void displayFamilyTreeInfo(String info) {
        System.out.println(info);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }
}
