import Commands.*;
import MainClasses.ListOfCommands;
import Network.Client;
import Network.Request;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ListOfCommands listOfCommands = new ListOfCommands();
        listOfCommands.putCommands("info", new Info());
        listOfCommands.putCommands("show", new Show());
        String input ;
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();


        while(true) {
            try {
                input = scanner.nextLine();
                if (listOfCommands.getCollection().get(input) != null) {
                    //Request request = new Request(listOfCommands.getCollection().get(input));
                    if (input.equals("info")) {
                        Request request = new Request(listOfCommands.getCollection().get(input));
                        client.sendTask(request);
                    }
                    if(input.equals("show")){
                        Request request = new Request(listOfCommands.getCollection().get(input));
                        client.sendTask(request);
                    }


                }else {
                    System.err.println("Такой команды нет");
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }

    }

}

