package view.menu;

import model.builder.FamilyType;
import model.builder.Human;
import view.ConsoleUI;
import view.listmenu.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MenuSelectedHuman {
    private List<Command> commands;

    public MenuSelectedHuman(ConsoleUI consoleUI, Human human, EnumSet<FamilyType> missingFamily, List<Human> potentialSpouses) {
        commands = new ArrayList<>();

        if (missingFamily.contains(FamilyType.SPOUSE)) {
            commands.add(new SpouseFamily(consoleUI, human, potentialSpouses));
        }
        if (missingFamily.contains(FamilyType.MOTHER)) {
            commands.add(new InstallMother(consoleUI, human));
        }
        if (missingFamily.contains(FamilyType.FATHER)) {
            commands.add(new InstallFather(consoleUI, human));
        }
        if (missingFamily.contains(FamilyType.CHILDREN)) {
            commands.add(new InstallChildren(consoleUI, human));
        }
        if(!missingFamily.isEmpty()){
            commands.add(new SaveFamilyTree(consoleUI));
        }
        if (consoleUI.getPresenter().getServiceFamilyTree().getFileHandler().isFileExists()) {
            commands.add(new ReadFamilyTree(consoleUI));
        }
        commands.add(new BackMenu(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
