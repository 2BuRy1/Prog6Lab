package Commands;

import Builders.SpaceMarineBuilder;
import Managers.CollectionManager;
import Exceptions.InvalidDataException;
import Exceptions.NoSuchElementException;

/**
 * Команда 'update'
 * Обновляет значение полей элемента коллекции
 */
public class UpdateById extends Command {

    public UpdateById() {
        super("update");

    }

    /**
     * @param args аргуметы команды
     *             Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

