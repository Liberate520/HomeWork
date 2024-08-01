package family_tree.view.menu;

import family_tree.view.View;

public class RemoveHuman implements command{
    public final String str = "Удалить человека";
    private View view;

    public RemoveHuman(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.removeHuman();
    }
}
