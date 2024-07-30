package View;

import View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
List<Command> mainMenuList;


public MainMenu(){
    mainMenuList = new ArrayList<>();
    mainMenuList.add(new ShowTree());
    mainMenuList.add(new AddtoTree());
    mainMenuList.add(new SortByName());
    mainMenuList.add(new SortByAmountOfChildren());
    mainMenuList.add(new SaveTreeToFile());
    mainMenuList.add(new RestoreTreeFromFile());
    mainMenuList.add(new addSpouseToFamilyMember());
    mainMenuList.add(new CloseMenu());
}

public void addToMainMenu(Command command){
    mainMenuList.add(command);
}

    public List<Command> getMainMenuList() {
        return mainMenuList;
    }

    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
        for (int i = 0; i <mainMenuList.size() ; i++) {
            sb.append(i + 1).append(". ").append(mainMenuList.get(i).getCommandName()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Command chooseCommand (Integer commandId){
        return mainMenuList.get(commandId-1);
    }

}
