package Commands;

import Managers.CollectionManager;
import Exceptions.EmptyCollectionException;

/**
 * Команда 'Show'
 * Выводит все содержимое коллекции
 */
public class Show extends Command {

    public Show(){
        super("show");

    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

