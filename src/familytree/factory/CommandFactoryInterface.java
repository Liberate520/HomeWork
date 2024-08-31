package familytree.factory;

import familytree.commands.Command;

public interface CommandFactoryInterface {
    Command getCommand(String commandKey);
}