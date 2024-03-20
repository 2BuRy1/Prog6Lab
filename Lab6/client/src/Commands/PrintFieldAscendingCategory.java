package Commands;

import Managers.CollectionManager;
import Exceptions.EmptyCollectionException;

/**
 * Команда 'print_field_ascending_category'
 * Выводит значенияполя category в порядке возрастания для всех элементов коллекции
 */
public class PrintFieldAscendingCategory extends Command {


    public PrintFieldAscendingCategory() {
        super("print_field_ascending_category");

    }

    /**
     * @param args аргументы команды
     *             Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

