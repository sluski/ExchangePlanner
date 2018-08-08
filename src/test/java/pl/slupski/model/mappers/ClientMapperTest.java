package pl.slupski.model.mappers;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.slupski.configuration.TestAppConfiguration;
import pl.slupski.controller.pojo.Client;
import pl.slupski.testable.ClientTestable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestAppConfiguration.class})
public class ClientMapperTest {
    @Autowired
    private ClientTestable clientTestable;
    @Autowired
    private ClientMapper clientMapper;
    
    private final static int INCORRECT_ID = 0;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void insert_correctObject_inDataBase(){
        int beforeElementsCount = clientMapper.findAll().size();
        clientMapper.insert(clientTestable.randomize(false));
        assertTrue(beforeElementsCount == clientMapper.findAll().size()-1);
    }
    
    @Test
    public void find_correctObject_foundOne(){
        Client before = clientTestable.randomize(false);
        clientMapper.insert(before);
        int id = before.getId();
        Client after = clientMapper.find(id);
        assertTrue(before.equals(after));
    }
    
    @Test
    public void find_incorrectObject_returnedNull(){
        Client found = clientMapper.find(INCORRECT_ID);
        assertTrue(found == null);
    }
    
    @Test
    public void findAll_objectInDb_foundMoreThanZero(){
        clientTestable.randomize(true);
        assertTrue(clientMapper.findAll().size() > 0);
    }
    
    @Test
    public void findAll_objectsNotInDb_returnedEmptyList(){
        clientMapper.deleteAll();
        assertTrue(clientMapper.findAll().isEmpty());
    }
    
    @Test
    public void deleteById_correctId_objectDeleted(){
        Client item = clientTestable.randomize(false);
        clientMapper.insert(item);
        clientMapper.deleteById(item.getId());
        assertTrue(clientMapper.find(item.getId()) == null);
    }
    
    @Test
    public void delete_correctObject_objectDeleted(){
        Client item = clientTestable.randomize(true);
        clientMapper.delete(item);
        assertTrue(clientMapper.find(item.getId()) == null);
    }
    
    @Test
    public void deleteAll_emptyDb(){
        clientTestable.randomize(true);
        clientMapper.deleteAll();
        assertTrue(clientMapper.findAll().isEmpty());
    }
    
}
