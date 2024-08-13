package family_tree.view.menu;

import family_tree.view.View;

public class GetAncestors implements command{
    public final String str = "Получить предков человека";
    private View view;

    public GetAncestors(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.getAncestors();
    }
}
