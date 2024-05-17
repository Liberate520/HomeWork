package View.Comands;

public class GetРersonList extends Command {
    private Console console;

    public GetРersonList(Console console) {
        super(console);
    }

    public String description(){
        return "Получить список людей";
    }

    public void execute(){
        getConsole().getРersonList();
    }

    private TypeOfRelationship<Рerson> getConsole() {
    }
}