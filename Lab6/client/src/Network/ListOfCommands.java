package Network;

import Commands.Add;
import Commands.Command;

import java.util.ArrayList;
import java.util.Collections;

public class ListOfCommands {

    private final ArrayList<Command> commands = new ArrayList<>();


    public void putCommand(Command command) {
        commands.add(command);
    }

    public ArrayList<Command> getCollection(){
        return this.commands;
    }

}


