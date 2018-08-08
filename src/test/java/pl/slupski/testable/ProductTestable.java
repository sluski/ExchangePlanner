package pl.slupski.testable;

import java.util.UUID;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.mappers.ProductMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class ProductTestable extends Testable<Product> {
   
    private final UnitTestable unitTestable;
    private final ProductMapper productMapper;
    
    public ProductTestable(ProductMapper productMapper, UnitTestable unitTestable){
        this.unitTestable = unitTestable;
        this.productMapper = productMapper;
    }

    @Override
    public Product randomize(boolean save) {
        Product result = new Product(UUID.randomUUID().toString(), unitTestable.randomize(true));
        if(save){
            result = new Product(UUID.randomUUID().toString(), unitTestable.randomize(true));
            productMapper.insert(result);
        }
        return result;
    }

   
}
