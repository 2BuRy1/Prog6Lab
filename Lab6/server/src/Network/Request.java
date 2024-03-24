package Network;

import Commands.Command;
import MainClasses.SpaceMarine;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 20L;
    public ArrayList<String> describe;
    public SpaceMarine spaceMarine;
    Command command;
    Object args;

    public Request(ArrayList<String> describe) {
        this.describe = describe;
    }

    public Request(ArrayList<String> describe, SpaceMarine spaceMarine) {
        this.describe = describe;
        this.spaceMarine=spaceMarine;
    }

    public Request(Command command ,SpaceMarine spaceMarine, Object args){
        this.command = command;
        this.spaceMarine = spaceMarine;
        this.args = args;

    }
    public Request(SpaceMarine spaceMarine, Object args){
        this.spaceMarine = spaceMarine;
        this.args = args;
    }

    public Request(Command command, SpaceMarine spaceMarine){
        this.command= command;
        this.spaceMarine = spaceMarine;
    }

    public Object getArgs(){
        return args;
    }

    public SpaceMarine getObject(){
        return this.spaceMarine;
    }

    public Command getCommand(){
        return command;
    }
}

