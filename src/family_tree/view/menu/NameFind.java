package family_tree.view.menu;

import family_tree.view.View;

public class NameFind implements command{
    public final String str = "Найти человека по имени";
    private View view;

    public NameFind(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.findHumanByName();
    }
}
