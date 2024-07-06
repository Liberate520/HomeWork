package view.check;

import view.MainMenu;

public class Check {
    private MainMenu menu;

    public Check(MainMenu menu) {
        this.menu = menu;
    }

    public boolean checkChoice(String choiceStr){
        if (choiceStr.matches("[0-9]*")){
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menu.size();
        }
        return false;
    }

    public boolean checkIntId(String idStr){
        if (idStr.matches("[0-9]*")){
            return true;
        }
        return false;
    }

}
