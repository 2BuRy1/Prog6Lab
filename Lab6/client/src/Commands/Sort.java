package Commands;

import Network.Request;
import Network.Response;

import java.io.Serial;
import java.io.Serializable;

public class Sort extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;


    public Sort() {
        super("sort");
    }


    @Override
    public Response execute(Request request) {
        return new Response("");
    }
}
