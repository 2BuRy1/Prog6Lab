package Commands;

import Network.Request;
import Network.Response;

import java.io.Serial;
import java.io.Serializable;

public class Info extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Info() {
        super("info");
    }

    @Override
    public Response execute(Request request) {

        return new Response(" ");
    }
}
