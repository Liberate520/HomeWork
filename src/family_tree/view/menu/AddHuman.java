package family_tree.view.menu;

import family_tree.view.View;

public class AddHuman implements command{
    public final String str = "Добавить человека";
    private View view;

    public AddHuman(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.addHuman();
    }
}
