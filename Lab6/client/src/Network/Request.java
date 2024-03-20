package Network;

import Commands.Command;
import MainClasses.SpaceMarine;

public class Request {

    private String args= "";

    private String CommandName;

    private Command command;



    private SpaceMarine spaceMarine;

    public Request(String args, String CommandName){
        this.args = args;
        this.CommandName=CommandName;
    }
    public Request(SpaceMarine spaceMarine){
        this.spaceMarine = spaceMarine;


    }

    public Request(String CommandName, SpaceMarine spaceMarine){
        this.CommandName = CommandName;
        this.spaceMarine = spaceMarine;
    }

    public Request(String CommandName){
        this.CommandName = CommandName;
    }


    public Request(Command command, String args){
        this.command = command;
        this.args =args;
    }

    public String getArgs(){
        return args;
    }

    public Request(Command command, SpaceMarine spaceMarine){
        this.command = command;
        this.spaceMarine = spaceMarine;
    }
    public Request(Command command, String args, SpaceMarine spaceMarine){
        this.command = command;
        this.args =args;
        this.spaceMarine = spaceMarine;
    }



}

