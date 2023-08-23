package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
//    private List<GetHumanList> list;

//    System.out.println("�������� �������:\n"
//            +"0. ����� �� ��������� \n"
//            +"1. �������� ������ ����� \n"
//            +"2. �������� ������������ \n"
//            +"3. ������������� ������ �� ��� \n"
//            +"4. ������������� ������ �� �������� \n"
//            +"5. ������������� ������ �� ���� �������� \n"
//            );

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Finish(consoleUI));
        commandList.add(new GetHumanList(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new SortByFullName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
//            stringBuilder.append("commandList.size() = "+ commandList.size() + commandList + "\n");
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
