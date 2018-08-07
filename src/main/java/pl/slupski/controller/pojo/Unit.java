package pl.slupski.controller.pojo;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Unit {

    public static final String TABLE_NAME = "t_unit";
    public static final String COLUMNS = "name, shortcut";
    public static final String PARAMETERS = "#{name}, #{shortcut}";
    public static final String ID_PARAMETR = "#{id}";
    private int id;
    private String name;
    private String shortcut;

    public Unit() {
    }

    public Unit(int id, String name, String shortcut) {
        this.id = id;
        this.name = name;
        this.shortcut = shortcut;
    }
    
    public Unit(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
    
    
}
