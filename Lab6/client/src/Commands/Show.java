package Commands;

import Managers.CommandManager;
import Network.Request;
import Network.Response;

import java.io.Serial;
import java.io.Serializable;

public class Show extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    public Show() {
        super("show");
    }

    @Override
    public Response execute(String args, Request request) {
        return null;
    }
}
