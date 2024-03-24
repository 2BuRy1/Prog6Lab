package MainClasses;

import Commands.Command;
import Managers.CommandType;

import java.util.HashMap;
import java.util.Set;

public class ListOfCommands {

    private HashMap<CommandType, Command> commands = new HashMap<>();


    public void putCommands(CommandType commandType, Command command) {
        commands.put(commandType, command);
    }

    public HashMap<CommandType, Command> getCollection() {
        return commands;
    }

    public CommandType getKey() {
        for (CommandType key : commands.keySet()) {
            return key;
        }
        return null;
    }
}
