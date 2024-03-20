package Commands;

import Managers.CollectionManager;

import Exceptions.EmptyCollectionException;

/**
 * Команда 'max_by_chapter'
 * Выводит элемент, значение поля chapter которого является максимальным
 */
public class MaxByChapter extends Command{



    public MaxByChapter(){
        super("max_by_chapter");
    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public  void execute(String args){

    }
}
