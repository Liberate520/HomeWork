package homeWork.view.command;

import homeWork.view.Console;

public class GetTreeList extends Command{
    public GetTreeList(Console console) {
        super("Получить семейное дерево", console);
    }

    public void execute(){
        console.getTreeList();
    }
}
