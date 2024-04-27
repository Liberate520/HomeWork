package family_TREE.view.comands;

import family_TREE.view.Console;

public class GetHumanList {
    private final Console console;

    public GetHumanList(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Получить список людей";
    }

    public void execute(){
        console.getHumanList();
    }
}
