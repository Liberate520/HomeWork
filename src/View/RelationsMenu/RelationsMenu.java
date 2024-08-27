package View.RelationsMenu;

import View.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class RelationsMenu {
    List<AddRelations> addRelationsList = new ArrayList<>();

    public RelationsMenu(ConsoleUI consoleUI) {
        addRelationsList.add(new AddSpouse(consoleUI));
        addRelationsList.add(new DeleteSpouse(consoleUI));
        addRelationsList.add(new AddParent(consoleUI));
        addRelationsList.add(new AddChild(consoleUI));
        addRelationsList.add(new FinishRelationsChoice(consoleUI));
    }

    public String RelationsMenuDescription(){
        StringBuilder sb = new StringBuilder();
        sb.append("Желаете изменить родственные связи с уже добавленными людьми?\n");
        for (int i = 0; i < addRelationsList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(addRelationsList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice, int humanID){
        addRelationsList.get(choice - 1).execute(humanID);
    }

    public int getListSize(){
        return addRelationsList.size();
    }
}
