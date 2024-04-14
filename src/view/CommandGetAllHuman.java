package view;

public class CommandGetAllHuman implements Commandable {

    View view;

    public CommandGetAllHuman(View view) {

        this.view = view;
    }

    @Override
    public void execute() {
        view.getAllHuman();


    }
    @Override
    public String description() {
        return "Вывод на экран всех людей";
    }
}


