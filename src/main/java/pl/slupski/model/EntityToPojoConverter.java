package pl.slupski.model;

import org.springframework.beans.factory.annotation.Autowired;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.entiy.TProduct;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.model.dao.UnitDao;
import pl.slupski.model.entiy.TUnit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class EntityToPojoConverter {
    
    @Autowired
    private UnitDao unitDao;
    
    public Product toProduct(final TProduct tProduct){
        return new Product(tProduct.getId(), tProduct.getName(), unitDao.find(tProduct.getUnitId()));
    }

    public Unit toUnit(final TUnit tUnit) {
        return new Unit(tUnit.getName(), tUnit.getShortcut());
    }
}
