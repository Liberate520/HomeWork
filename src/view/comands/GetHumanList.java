package view.comands;

import view.Console;

public class GetHumanList {
    private Console console;

    public GetHumanList(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Get Human List";
    }

    public void execute(){
        console.getHumanList();
    }
}