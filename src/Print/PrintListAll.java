package Print;

import Homework_5.Designer_Human;

import java.util.List;

public class PrintListAll implements InterfacePrintList{
    Designer_Human designer_human;
    @Override
    public void printList(List<Designer_Human> humans) {
        for (Designer_Human human : designer_human.getHumans()) {
            System.out.println(human.toString());
        }
    }
}
