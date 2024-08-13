package family_tree.view.menu;

import family_tree.view.View;

public class Exit implements command{
    public final String str = "Выход";
    private View view;

    public Exit(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.exit();
    }
}
