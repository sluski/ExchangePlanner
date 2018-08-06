package pl.slupski.model.entiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Entity
@Table(name="t_unit")
public class TUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortcut;

    public TUnit() {
    }

    public TUnit(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public TUnit(Unit unit){
        this.name = unit.getName();
        this.shortcut = unit.getShortcut();
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
