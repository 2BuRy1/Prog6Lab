package MainClasses;

import Commands.Command;
import Enums.MeleeWeapon;
import Managers.CommandType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListOfCommands {

    private HashMap<String, Command> commands = new HashMap<>();


    public void putCommands(Command command) {
        commands.put(command.getName(), command);
    }

    public HashMap<String, Command> getCollection() {
        return commands;
    }


}

