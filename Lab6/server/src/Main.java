import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import Commands.*;
import Managers.RunManager;
import Network.Server;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(collectionManager);
        RunManager runManager = new RunManager(commandManager);
        if (args.length != 0) {
            try {
                fileManager.readFromCollection(args[0]);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");;
            }
            System.out.println("Коллекция успешно загружена!");
        } else {
            System.out.println("Файл не обнаружен");
            System.exit(1);
        }

        System.out.println("Для сводки по командам введите : help");

        commandManager.addCommand(new Info(collectionManager));
        commandManager.addCommand(new Show(collectionManager));
        commandManager.addCommand(new Clear(collectionManager));
        commandManager.addCommand(new Sort(collectionManager));
        commandManager.addCommand(new MaxByChapter(collectionManager));
        commandManager.addCommand(new PrintFieldAscendingCategory(collectionManager));
        commandManager.addCommand(new Add(collectionManager));
        Server server = new Server(runManager);
        server.runServer();

    }

}

