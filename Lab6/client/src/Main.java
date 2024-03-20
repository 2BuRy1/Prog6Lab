import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import Commands.*;
import Managers.RunManager;
import Network.Client;
import Network.ListOfCommands;

import javax.security.auth.login.AccountLockedException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        Client client = new Client("localhost", 1488);
        ListOfCommands listOfCommands = new ListOfCommands();
       // Client client= new Client();
       //RunManager runManager = new RunManager(new Scanner(System.in), listOfCommands);
        commandManager.addCommand(new Add());
        commandManager.addCommand(new Help());
        commandManager.addCommand(new AddIfMin());
        commandManager.addCommand(new Clear());
        commandManager.addCommand(new CountByMeleeWeapon());
        commandManager.addCommand(new Info());
        commandManager.addCommand(new InsertAtIndex());
        commandManager.addCommand(new MaxByChapter());
        commandManager.addCommand(new PrintFieldAscendingCategory());
        commandManager.addCommand(new RemoveById());
        commandManager.addCommand(new Show());
        commandManager.addCommand(new Sort());
        commandManager.addCommand(new UpdateById());
        commandManager.addCommand(new Exit());

        RunManager runManager = new RunManager(new Scanner(System.in), client, commandManager);
        runManager.run();
    }

}

