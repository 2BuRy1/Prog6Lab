package Network;

import MainClasses.SpaceMarine;

import java.io.Serializable;
import java.util.ArrayList;

public class Response {
    public ArrayList<String> describe;
    public SpaceMarine spaceMarine;

    public Response(ArrayList<String> describe) {
        this.describe = describe;
    }

    public Response(ArrayList<String> describe, SpaceMarine spaceMarine) {
        this.describe = describe;
        this.spaceMarine=spaceMarine;
    }
}

}
