package pl.slupski.controller.pojo;

import java.io.Serializable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Product extends Entity {

    public static final String TABLE_NAME = "t_product";
    public static final String COLUMNS = "name, unit_id";
    public static final String PARAMETERS = "#{name}, #{unit.id}";

    private String name;
    private Unit unit;

    public Product(final String name, final Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public Product(final int id, final String name, final Unit unit) {
        super(id);
        this.name = name;
        this.unit = unit;
    }

    public Product() {
        //empty
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        Product object = (Product) obj;
        if (!this.name.equals(object.name)) {
            return false;
        }
        if (!this.unit.equals(object.unit)) {
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

}
