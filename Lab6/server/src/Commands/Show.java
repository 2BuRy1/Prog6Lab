package Commands;

import Exceptions.EmptyCollectionException;
import Managers.CollectionManager;
import Network.Request;
import Network.Response;

import java.io.Serial;
import java.io.Serializable;

public class Show extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(String args, Request request) {
        return new Response(collectionManager.toString());

    }
}

