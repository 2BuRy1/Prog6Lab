package Commands;

import Builders.SpaceMarineBuilder;
import Managers.CollectionManager;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidDataException;


/**
 * Команда 'add_if_min'
 * Добавляет новый элемент в коллекцию, если значение его поля наименьшее
 */
public class AddIfMin extends Command {



    public AddIfMin() {
        super("add_if_min");

    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
  @Override
  public void execute(String args) {

  }
}