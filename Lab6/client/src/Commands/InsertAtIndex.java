package Commands;

import Builders.SpaceMarineBuilder;
import Managers.CollectionManager;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;

/**
 * Команды 'insert_at'
 * Вставляет новый элемент в заданную позицию в коллекции
 */
public class InsertAtIndex  extends Command {



    public InsertAtIndex() {
        super("insert_at");

    }

    /**
     * @param args аргументы команы
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

