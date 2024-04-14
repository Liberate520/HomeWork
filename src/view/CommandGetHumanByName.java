package view;

public class CommandGetHumanByName implements Commandable {
    View view;

    public CommandGetHumanByName(View view){
        this.view = view;
    }

    @Override
    public void execute() {

        view.getHumanByName();
    }

//    }
    @Override
    public String description() {

        return "Опция поиска человека по имени";
    }

//    @Override
//    public String toString() {
//        return get
//    }
}


