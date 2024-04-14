package view;

public class CommandSortByAge implements Commandable {

    View view;

    public CommandSortByAge(View view) {
        this.view = view;
    }


    @Override
    public void execute() {
        view.sortByAge();

    }

    @Override
    public String description() {
        return "Сортировка по возрасту";
    }
}


