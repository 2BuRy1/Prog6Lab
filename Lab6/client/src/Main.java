import Builders.SpaceMarineBuilder;
import Commands.*;
import MainClasses.ListOfCommands;
import MainClasses.SpaceMarine;
import Managers.CommandType;
import Network.Client;
import Network.Request;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ListOfCommands listOfCommands = new ListOfCommands();
        listOfCommands.putCommands(CommandType.INFO, new Info());
        listOfCommands.putCommands(CommandType.SHOW, new Show());
        listOfCommands.putCommands(CommandType.CLEAR, new Clear());
        listOfCommands.putCommands(CommandType.SORT, new Sort());
        listOfCommands.putCommands(CommandType.MAX_BY_CHAPTER, new MaxByChapter());
        listOfCommands.putCommands(CommandType.PRINT_FIELD_ASCENDING_CATEGORY, new PrintFieldAscendingCategory());
        listOfCommands.putCommands(CommandType.ADD, new Add());
        String[] input;
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();


        while (true) {
            input = scanner.nextLine().trim().split(" ");
            if (listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())) != null) {
                if (!listOfCommands.getKey().getArgument()) {
                    if (input.length != 1) {
                        System.err.println("Этой команде не нужны аргументы");
                        continue;
                    }
                    if(input[0].equals("add") || input[0].equals("add_if_min")){
                        SpaceMarine spaceMarine = new SpaceMarineBuilder().create();
                        client.sendTask(new Request(listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())), spaceMarine));
                    }
                    else {

                        Request request = new Request(listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())));
                        client.sendTask(request);
                    }
                }


                    else{
                        if (input.length != 2) {
                            System.err.println("Этой команде нужен ровно один аргумент");
                            continue;
                        }
                        if(input[0].equals("execute_script") || input[0].equals("count_less_than_melee_weapon")){
                            Request request = new Request(listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())), input[1]);
                            client.sendTask(request);
                        }
                        else{
                            int id;
                            id = Integer.parseInt(input[1]);
                            if(input[0].equals("insert_at") || input[0].equals("update")){
                                SpaceMarine spaceMarine = new SpaceMarineBuilder().create();
                                client.sendTask(new Request(listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())),spaceMarine, id));
                            }
                            else {
                                client.sendTask(new Request(listOfCommands.getCollection().get(CommandType.valueOf(input[0].toUpperCase())), id));
                            }
                        }
                    }




            } else {
                System.err.println("Такой команды нет");
            }
        }
    }

}




