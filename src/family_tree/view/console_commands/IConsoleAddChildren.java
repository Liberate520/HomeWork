package family_tree.view.console_commands;

public interface IConsoleAddChildren {
    boolean addChildrenCon();
    long getIdFather();
    long getIdMother();
    long getIdChildren();
}
