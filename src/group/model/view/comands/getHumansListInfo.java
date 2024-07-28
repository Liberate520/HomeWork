package group.model.view.comands;

import group.model.view.ConsoleUI;

public class getHumansListInfo extends Commands {
    public getHumansListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description= "Получить список родственников";
    }



    public void execute(){
        consoleUI.getHumansListInfo();
    }
}
