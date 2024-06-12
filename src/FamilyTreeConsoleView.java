import java.util.List;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private FamilyTreePresenter presenter;

    public FamilyTreeConsoleView(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayMemberDescriptions(List<String> descriptions) {
        for (String description : descriptions) {
            System.out.println(description);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayChildren(List<TreeMember> children) {
        if (children.isEmpty()) {
            System.out.println("Дети не найдены.");
        } else {
            for (TreeMember child : children) {
                System.out.println(child);
            }
        }
    }
}
