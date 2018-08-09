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
import pl.slupski.controller.pojo.OrderItem;
import pl.slupski.test.GlobalDataBaseActions;
import pl.slupski.testable.OrderItemTestable;
import pl.slupski.testable.OrderItemTestable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfiguration.class)
public class OrderItemMapperTest {
    
    @Autowired
    private OrderItemTestable orderItemTestable;
    @Autowired
    private OrderItemMapper orderItemMapper;
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
        int beforeElementsCount = orderItemMapper.findAll().size();
        orderItemMapper.insert(orderItemTestable.randomize(false));
        assertTrue(beforeElementsCount == orderItemMapper.findAll().size() - 1);
    }

    @Test
    public void find_correctObject_foundOne() {
        OrderItem before = orderItemTestable.randomize(false);
        orderItemMapper.insert(before);
        int id = before.getId();
        OrderItem after = orderItemMapper.find(id);
        assertTrue(before.equals(after));
    }

    @Test
    public void find_incorrectObject_returnedNull() {
        OrderItem found = orderItemMapper.find(INCORRECT_ID);
        assertTrue(found == null);
    }

    @Test
    public void findAll_objectInDb_foundMoreThanZero() {
        assertTrue(orderItemMapper.findAll().isEmpty());
        orderItemTestable.randomize(true);
        assertTrue(orderItemMapper.findAll().size() > 0);
    }

    @Test
    public void findAll_objectsNotInDb_returnedEmptyList() {
        orderItemMapper.deleteAll();
        assertTrue(orderItemMapper.findAll().isEmpty());
    }

    @Test
    public void deleteById_correctId_objectDeleted() {
        OrderItem item = orderItemTestable.randomize(false);
        orderItemMapper.insert(item);
        assertTrue(orderItemMapper.find(item.getId()) != null);
        orderItemMapper.deleteById(item.getId());
        assertTrue(orderItemMapper.find(item.getId()) == null);
    }

    @Test
    public void delete_correctObject_objectDeleted() {
        OrderItem item = orderItemTestable.randomize(true);
        assertTrue(orderItemMapper.find(item.getId()) != null);
        orderItemMapper.delete(item);
        assertTrue(orderItemMapper.find(item.getId()) == null);
    }

    @Test
    public void deleteAll_emptyDb() {
        orderItemTestable.randomize(true);
        assertTrue(!orderItemMapper.findAll().isEmpty());
        orderItemMapper.deleteAll();
        assertTrue(orderItemMapper.findAll().isEmpty());
    }
}
