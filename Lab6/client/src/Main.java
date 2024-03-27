import Builders.SpaceMarineBuilder;
import Commands.*;
import Enums.MeleeWeapon;
import MainClasses.ListOfCommands;
import MainClasses.SpaceMarine;
import Managers.CommandType;
import Network.Client;
import Network.Program;
import Network.Request;

import java.io.IOException;
import java.util.Scanner;

import static Enums.MeleeWeapon.valueOf;


public class Main {

    public static void main(String[] args) throws IOException{

        Program program = new Program();
        program.execute();

    }
}




