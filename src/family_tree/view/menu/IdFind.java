package family_tree.view.menu;

import family_tree.view.View;

public class IdFind implements  command{
    public final String str = "Найти человека по Id";
    private View view;

    public IdFind(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.findHumanByID();
    }
}
