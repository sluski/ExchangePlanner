package pl.slupski.controller.pojo;

import java.io.Serializable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Unit extends Entity {

    public static final String TABLE_NAME = "t_unit";
    public static final String COLUMNS = "name, shortcut";
    public static final String PARAMETERS = "#{name}, #{shortcut}";

    private String name;
    private String shortcut;

    public Unit() {
    }

    public Unit(final int id, final String name, final String shortcut) {
        super(id);
        this.name = name;
        this.shortcut = shortcut;
    }

    public Unit(final String name, final String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        Unit object = (Unit) obj;
        if (!this.name.equals(object.getName())) {
            return false;
        }
        if (!this.shortcut.equals(object.getShortcut())) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(final String shortcut) {
        this.shortcut = shortcut;
    }

}
