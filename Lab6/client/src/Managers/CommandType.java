package Managers;

public enum CommandType {
    SHOW(0, "show"),
    INFO(0, "info"),
    ADD(0, "add"),
    UPDATE(1, "update"),
    REMOVE_BY_ID(1, "remove_by_id"),
    CLEAR(0, "clear"),
    EXECUTE_SCRIPT(1, "execute_script"),
    INSERT_AT(1, "insert_at"),
    ADD_IF_MIN(0, "add_id_min"),
    SORT(0, "sort"),
    MAX_BY_CHAPTER(0, "max_by_chapter"),
    COUNT_LESS_THAN_MELEE_WEAPON(1, "count_less_than_melee_weapon"),
    PRINT_FIELD_ASCENDING_CATEGORY(0, "print_field_ascending_categoy"),
    HELP(0, "help");


    private final int Arguments;
    private final String name;

    CommandType(int Arguments, String name){
        this.Arguments = Arguments;
        this.name = name;

    }

    public String getName(){
        return this.name;
    }

    public int getArgument(){
        return this.Arguments;
    }







}
