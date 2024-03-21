package Commands;

import Managers.CollectionManager;
import Network.Request;
import Network.Response;

/**
 * Команда 'info'
 * Выводит основную информацию о коллекции
 */
public class Info extends Command {

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    /**
     * @param args аргументы команды
     *             Метод запуска команды
     */
    @Override
    public Response execute(String args, Request request) {
        return new Response(collectionManager.getInfo());
    }
}
