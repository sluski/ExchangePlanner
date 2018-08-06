package pl.slupski.controller.pojo;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Product {

    private int id;
    private String name;
    private Unit unit;

    public Product(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public Product(int id, String name, Unit unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }
    
    public Product() {
        //empty
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    
}
