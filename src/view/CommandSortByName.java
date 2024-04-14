package view;

public class CommandSortByName implements Commandable {

    View view;

    public CommandSortByName(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.sortByName();


    }
    @Override
    public String description() {
        return "Сотировка по имени";
    }
}


