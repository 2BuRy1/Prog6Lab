package Commands;

import Managers.CollectionManager;
import Exceptions.NoSuchElementException;

/**
 * Команда 'remove_by_id'
 * Удаление элемента коллекции по его id
 */
public class RemoveById extends Command {


    public RemoveById() {
        super("remove_by_id");
    }

    /**
     * @param args аргументы команды
     *             Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

