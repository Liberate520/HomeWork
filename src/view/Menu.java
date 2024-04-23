package view;

import view.util.ConsoleColors;
import view.comands.GetHumanList;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<GetHumanList> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new GetHumanList(console));
    }

    public String createMenuItem(
            Integer number, String title
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsoleColors.YELLOW_BOLD);
        sb.append(number);
        sb.append(". ");
        sb.append(ConsoleColors.RESET);
        sb.append(title);
        sb.append("\n");
        return sb.toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(createMenuItem(i + 1, list.get(i).getDescription()));
        }
        return sb.toString();
    }

    public void execute(String choice) {
        list.get(Integer.parseInt(choice) - 1).execute();
    }
}