import Builders.SpaceMarineBuilder;
import Commands.*;
import Enums.MeleeWeapon;
import MainClasses.ListOfCommands;
import MainClasses.SpaceMarine;
import Managers.CommandType;
import Network.Client;
import Network.Request;

import java.io.IOException;
import java.util.Scanner;

import static Enums.MeleeWeapon.valueOf;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ListOfCommands listOfCommands = new ListOfCommands();
        listOfCommands.putCommands( new Update());
        listOfCommands.putCommands( new Show());
        listOfCommands.putCommands( new Clear());
        listOfCommands.putCommands( new Sort());
        listOfCommands.putCommands( new MaxByChapter());
        listOfCommands.putCommands( new PrintFieldAscendingCategory());
        listOfCommands.putCommands( new Add());
        listOfCommands.putCommands( new Help());
        listOfCommands.putCommands( new AddIfMin());
        listOfCommands.putCommands( new Info());
        listOfCommands.putCommands(new Insert());
        listOfCommands.putCommands(new Remove());
        listOfCommands.putCommands(new CountLess());
        String[] input;
        Scanner scanner = new Scanner(System.in);
        Client client = new Client("localhost", 155, 5000, 5);

        System.out.println("Введите help для вывода справки по командам: ");
        while (true) {
            //try {
                String cmd = (scanner.nextLine() + " ").trim();
                input = cmd.split(" ");
                if (input[0].equals("exit")) {
                    System.out.println("До свидания!");
                    System.exit(1);
                }
                if (listOfCommands.getCollection().get(input[0]) != null) {
                    if (!listOfCommands.getCollection().get(input[0]).isHasArguments()) {
                        if (input.length != 1) {
                            System.err.println("Этой команде не нужны аргументы");
                            continue;
                        }
                        if (input[0].equals("add") || input[0].equals("add_if_min")) {
                            SpaceMarine spaceMarine = new SpaceMarineBuilder().create();
                            System.out.println(client.sendRequest(new Request(listOfCommands.getCollection().get(input[0]), spaceMarine)).getResult());

                        } else {

                            Request request = new Request(listOfCommands.getCollection().get(input[0]));
                            System.out.println(client.sendRequest(request).getResult());
                        }
                    } else {

                        if (input.length != 2) {
                            System.err.println("Этой команде нужен ровно один аргумент");
                            continue;
                        }
                        if (input[0].equals("execute_script") || input[0].equals("count_less_than_melee_weapon")) {
                            Request request = new Request(listOfCommands.getCollection().get(input[0]), input[1].toUpperCase());
                            System.out.println(client.sendRequest(request).getResult());
                        } else {
                            int id;
                            id = Integer.parseInt(input[1]);
                            if (input[0].equals("insert_at") || input[0].equals("update")) {
                                SpaceMarine spaceMarine = new SpaceMarineBuilder().create();
                                System.out.println(client.sendRequest(new Request(listOfCommands.getCollection().get(input[0]), spaceMarine, id)).getResult());
                            } else {
                                System.out.println(client.sendRequest(new Request(listOfCommands.getCollection().get(input[0]), id)).getResult());
                            }
                        }
                    }



                } else {
                    System.err.println("Такой команды нет");
                }
        }

    }
}




