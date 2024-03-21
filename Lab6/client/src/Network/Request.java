package Network;

import Commands.Command;
import MainClasses.SpaceMarine;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    public ArrayList<String> describe;
    public SpaceMarine spaceMarine;
    Command command;
    String args= "";

    public Request(ArrayList<String> describe) {
        this.describe = describe;
    }

    public Request(ArrayList<String> describe, SpaceMarine spaceMarine) {
        this.describe = describe;
        this.spaceMarine=spaceMarine;
    }

    public Request(Command command, String args){
        this.command = command;
        this.args = args;
    }

    public String getArgs(){
        return args;
    }

    public Command getCommand(){
        return command;
    }
    public Request(Command command){
        this.command = command;
    }
}

