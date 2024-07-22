import presenter.FamilyTreePresenter;
import view.ConsoleFamilyTreeView;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);
        presenter.start();
    }
}
