package Managers;

import Commands.Command;
import Network.Request;
import Network.Response;

import java.util.HashMap;

/**
 * Класс, отвечающий за исполнение команд
 */
public class CommandManager {

    private  HashMap<String, Command> commands = new HashMap<>();

    /**
     * @param command команда, добавляемая в Map
     */
    public void addCommand(Command command){

        this.commands.put(command.getName(), command);
    }
    /**
     * @param request название команды
     * @param args ее аргументы(id элемента, index коллекции и тд)
     */
    public Response execute(String args, Request request){
        Command command = commands.get(request.getCommand().getName());
        if (command== null){
            return new Response("Такой команды нет");
        }
        else {
            return command.execute(args, request);
        }
    }
}
