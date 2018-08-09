package pl.slupski.model.mappers;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.slupski.configuration.TestAppConfiguration;
import pl.slupski.controller.pojo.Product;
import pl.slupski.test.GlobalDataBaseActions;
import pl.slupski.testable.ProductTestable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestAppConfiguration.class})
public class ProductMapperTest {

    @Autowired
    private ProductTestable productTestable;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private GlobalDataBaseActions globalActions;

    private final static int INCORRECT_ID = 0;

    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @After
    public void tearDown() {
        globalActions.fullClearDataBase();
    }


    @Test
    public void insert_correctObject_inDataBase() {
        int beforeElementsCount = productMapper.findAll().size();
        productMapper.insert(productTestable.randomize(false));
        assertTrue(beforeElementsCount == productMapper.findAll().size() - 1);
    }

    @Test
    public void find_correctObject_foundOne() {
        Product before = productTestable.randomize(false);
        productMapper.insert(before);
        int id = before.getId();
        Product after = productMapper.find(id);
        assertTrue(before.equals(after));
    }

    @Test
    public void find_incorrectObject_returnedNull() {
        Product found = productMapper.find(INCORRECT_ID);
        assertTrue(found == null);
    }

    @Test
    public void findAll_objectInDb_foundMoreThanZero() {
        assertTrue(productMapper.findAll().isEmpty());
        productTestable.randomize(true);
        assertTrue(productMapper.findAll().size() > 0);
    }

    @Test
    public void findAll_objectsNotInDb_returnedEmptyList() {
        productMapper.deleteAll();
        assertTrue(productMapper.findAll().isEmpty());
    }

    @Test
    public void deleteById_correctId_objectDeleted() {
        Product item = productTestable.randomize(false);
        productMapper.insert(item);
        assertTrue(productMapper.find(item.getId()) != null);
        productMapper.deleteById(item.getId());
        assertTrue(productMapper.find(item.getId()) == null);
    }

    @Test
    public void delete_correctObject_objectDeleted() {
        Product item = productTestable.randomize(true);
        assertTrue(productMapper.find(item.getId()) != null);
        productMapper.delete(item);
        assertTrue(productMapper.find(item.getId()) == null);
    }

    @Test
    public void deleteAll_emptyDb() {
        productTestable.randomize(true);
        assertTrue(!productMapper.findAll().isEmpty());
        productMapper.deleteAll();
        assertTrue(productMapper.findAll().isEmpty());
    }
    
    @Test
    public void update_correctData_objectChanged(){
        Product before = productTestable.randomize(true);
        Product toUpdate = before;
        toUpdate.setName("changedName");
        productMapper.update(toUpdate);
        assertTrue(toUpdate.equals(productMapper.find(toUpdate.getId())));
    }
}
