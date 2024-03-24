package Commands;

import Network.Request;
import Network.Response;

import java.io.Serial;
import java.io.Serializable;

public class Add extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 7L;
    public Add() {
        super("add");
    }

    @Override
    public Response execute(Request request) {
        return new Response("");
    }
}
