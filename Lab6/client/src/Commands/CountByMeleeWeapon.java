package Commands;

import Managers.CollectionManager;
import Enums.MeleeWeapon;
import Exceptions.EmptyCollectionException;

/**
 * Команда 'count_less_than_melee_weapon'
 * Посчитает количество объектов, поле meleeweapon у которых меньше заданного
 */
public class CountByMeleeWeapon extends Command {

    public CountByMeleeWeapon() {
        super("count_less_than_melee_weapon");

    }

    /**
     * @param args аргументы команды
     * Метод запуска команды
     */
    @Override
    public void execute(String args) {

    }
}

