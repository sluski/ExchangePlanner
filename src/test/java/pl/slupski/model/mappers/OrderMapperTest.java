package pl.slupski.model.mappers;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.slupski.configuration.TestAppConfiguration;
import pl.slupski.controller.pojo.Order;
import pl.slupski.test.GlobalDataBaseActions;
import pl.slupski.testable.OrderTestable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestAppConfiguration.class})
public class OrderMapperTest {

    @Autowired
    private OrderTestable orderTestable;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GlobalDataBaseActions globalActions;

    private final static int INCORRECT_ID = 0;

    @After
    public void tearDown() {
        globalActions.fullClearDataBase();
    }

    @Test
    public void insert_correctObject_inDataBase() {
        int beforeElementsCount = orderMapper.findAll().size();
        orderMapper.insert(orderTestable.randomize(false));
        assertTrue(beforeElementsCount == orderMapper.findAll().size() - 1);
    }

    @Test
    public void find_correctObject_foundOne() {
        Order before = orderTestable.randomize(false);
        orderMapper.insert(before);
        int id = before.getId();
        Order after = orderMapper.find(id);
        assertTrue(before.equals(after));
    }

    @Test
    public void find_incorrectObject_returnedNull() {
        Order found = orderMapper.find(INCORRECT_ID);
        assertTrue(found == null);
    }

    @Test
    public void findAll_objectInDb_foundMoreThanZero() {
        assertTrue(orderMapper.findAll().isEmpty());
        orderTestable.randomize(true);
        assertTrue(orderMapper.findAll().size() > 0);
    }

    @Test
    public void findAll_objectsNotInDb_returnedEmptyList() {
        orderMapper.deleteAll();
        assertTrue(orderMapper.findAll().isEmpty());
    }

    @Test
    public void deleteById_correctId_objectDeleted() {
        Order item = orderTestable.randomize(false);
        orderMapper.insert(item);
        assertTrue(orderMapper.find(item.getId()) != null);
        orderMapper.deleteById(item.getId());
        assertTrue(orderMapper.find(item.getId()) == null);
    }

    @Test
    public void delete_correctObject_objectDeleted() {
        Order item = orderTestable.randomize(true);
        assertTrue(orderMapper.find(item.getId()) != null);
        orderMapper.delete(item);
        assertTrue(orderMapper.find(item.getId()) == null);
    }

    @Test
    public void deleteAll_emptyDb() {
        orderTestable.randomize(true);
        assertTrue(!orderMapper.findAll().isEmpty());
        orderMapper.deleteAll();
        assertTrue(orderMapper.findAll().isEmpty());
    }
}
