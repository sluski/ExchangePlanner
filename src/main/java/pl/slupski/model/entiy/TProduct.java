package pl.slupski.model.entiy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Entity
@Table(name = "t_product")
public class TProduct implements Serializable {

    public static final String SIMPLE_CLASS_NAME = "TProduct";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "unit")
    private int unitId;

    public TProduct() {
        // empty
    }

    public TProduct(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.unitId = product.getUnit().getId();
    }

    public TProduct(String name, int unit) {
        this.name = name;
        this.unitId = unit;
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

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
    
}
