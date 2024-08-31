package familytree.commands;

public class ExitCommand implements Command {
    @Override
    public boolean execute() {
        System.exit(0);
        return false;
    }
}
