package Managers;

import Builders.SpaceMarineBuilder;
import Commands.Command;
import Exceptions.InvalidDataException;
import MainClasses.SpaceMarine;
import Network.*;

import java.util.Objects;
import java.util.Scanner;

/**
 * Класс, обрабатывающий пользовательскй ввод
 */
public class RunManager {


    private final Client client;
    private CommandManager commandManager;
    private Scanner scanner;

    public RunManager(Scanner scanner, Client client, CommandManager commandManager) {
        this.scanner = scanner;
        this.client = client;
        this.commandManager = commandManager;
    }

    /**
     * Метод, запускающий выполнение команд
     */
    public void run() {
        while (scanner.hasNext()) {
            try {
                String[] usercommand = (scanner.nextLine().trim().split(" ", 2));
                Command command = commandManager.getCommands(usercommand[0].trim());
                if (command == null) System.err.println("такой команды нет");
                Responce responce = client.sendRequest(new Request(command, usercommand[1].trim()));
                this.printResponse(responce);
                switch (responce.getResponceStatus()) {
                    case ADD -> {
                        SpaceMarine spaceMarine = null;
                        try {
                            spaceMarine = new SpaceMarineBuilder().create();
                        } catch (InvalidDataException e) {
                            System.err.println("Поля объекта не валидны, объект не создан");
                            ;
                        }
                        if (!spaceMarine.validate()) ;

                        Responce newRersponce = client.sendRequest(new Request(command, usercommand[1], spaceMarine));

                        if (newRersponce.getResponceStatus() != ResponceStatus.OK) {
                            System.out.println(newRersponce.getResponce());
                        } else {
                            printResponse(newRersponce);

                        }

                    }
                    case EXIT -> System.exit(1);
                    //TODO
                }

            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
    }

        private void printResponse(Responce responce) {
        switch (responce.getResponceStatus()) {
            case OK -> {
                if ((Objects.isNull(responce.getCollection()))) {
                    System.out.println(responce.getResponce());
                } else {
                    System.out.println(responce.getResponce() + "\n" + responce.getCollection().toString());
                }
            }
            default -> {
            }
        }
    }
}


