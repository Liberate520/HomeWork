import notes.Notes;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.DesctopUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new DesctopUI();
        Notes notes = new Notes();
        Presenter presenter = new Presenter(view, notes);
        view.selection();
    }
}
