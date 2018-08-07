package pl.slupski.controller.services;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.slupski.controller.interfaces.ProductServiceInterface;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.mappers.ProductMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class ProductService implements ProductServiceInterface {

    private ProductMapper mapper;
    
    public ProductService(ProductMapper mapper){
        this.mapper = mapper;
    }
    
    @Override
    public int add(Product item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product find(int id){
        return mapper.find(id);
    }
    
    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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