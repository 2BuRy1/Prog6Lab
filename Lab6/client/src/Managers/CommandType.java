package Managers;

public enum CommandType {
    SHOW(false, "show"),
    INFO(false, "info"),
    ADD(false, "add"),
    UPDATE(true, "update"),
    REMOVE_BY_ID(true, "remove_by_id"),
    CLEAR(false, "clear"),
    EXECUTE_SCRIPT(true, "execute_script"),
    EXIT(false, "exit"),
    INSERT_AT(true, "insert_at"),
    ADD_IF_MIN(false, "add_id_min"),
    SORT(false, "sort"),
    MAX_BY_CHAPTER(false, "max_by_chapter"),
    COUNT_LESS_THAN_MELEE_WEAPON(true, "count_less_than_melee_weapon"),
    PRINT_FIELD_ASCENDING_CATEGORY(false, "print_field_ascending_categoy");


    private final boolean hasArguments;
    private final String name;

    CommandType(boolean hasArguments, String name){
        this.name = name;
        this.hasArguments = hasArguments;

    }

    public String getName(){
        return this.name;
    }

    public boolean getArgument(){
        return this.hasArguments;
    }


    public String toString(){
        return this.name;
    }




}
