package lv.homeWork.view;

import lv.homeWork.view.options.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Option> optionList;

    public MainMenu(ConsoleUI consoleUI) {
        optionList = new ArrayList<>();
        optionList.add(new AddHuman(consoleUI));
        optionList.add(new FindHumanByName(consoleUI));
        optionList.add(new ShowList(consoleUI));
        optionList.add(new SortByAge(consoleUI));
        optionList.add(new SortByGen(consoleUI));
        optionList.add(new FinishHIm(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < optionList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(".  ");
            stringBuilder.append(optionList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void act(int option){
        Option option1 = optionList.get(option-1);
        option1.act();

    }

    public int getSize(){
        return optionList.size();
    }
}
