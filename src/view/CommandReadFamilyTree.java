package view;


public class CommandReadFamilyTree implements Commandable {
    View view;

    public CommandReadFamilyTree(){
        this.view = view;
    }
    @Override
    public void execute() {
        view.commandReadFamilyTree();

    }
    @Override
    public String description() {
        return "Напечатаем дерево";
    }
}





