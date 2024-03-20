package Commands;

import Managers.CollectionManager;
import Exceptions.AlreadyEmptyException;


/**
 * Команда 'clear'
 * Очищает содержимое коллекции
 */
public class Clear extends Command {


    public Clear() {
        super("clear");

    }

    /**
     * @param args аргументы команды
     *             Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

