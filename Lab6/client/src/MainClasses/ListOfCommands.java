package MainClasses;

import Commands.Command;

import java.util.HashMap;

public class ListOfCommands {

    private HashMap<String, Command> commands = new HashMap<>();


    public void putCommands(String name, Command command){
        commands.put(name, command);
    }

    public HashMap<String, Command> getCollection(){
        return commands;
    }
}
