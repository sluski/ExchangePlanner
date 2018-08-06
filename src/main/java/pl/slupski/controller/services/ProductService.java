package pl.slupski.controller.services;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.slupski.controller.interfaces.ProductServiceInterface;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.dao.ProductDao;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class ProductService implements ProductServiceInterface {
    
    private final ProductDao dao;
    
    public ProductService(final ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public int add(Product item) {
        return dao.add(item);
    }

    @Override
    public Product find(int id) {
        return dao.find(id);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(Product item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}