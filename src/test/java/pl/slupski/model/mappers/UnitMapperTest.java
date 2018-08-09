package pl.slupski.model.mappers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.slupski.configuration.TestAppConfiguration;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.test.GlobalDataBaseActions;
import pl.slupski.testable.UnitTestable;

/**
 *
 * @author Sluski
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestAppConfiguration.class})
public class UnitMapperTest {

    @Autowired
    private UnitTestable unitTestable;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private GlobalDataBaseActions globalActions;
    
    
    private final static int INCORRECT_ID = 0;

    public UnitMapperTest() {

    }

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
        globalActions.fullClearDataBase();
    }

    @Test
    public void insert_correctObject_inDataBase() {
        int beforeElementsCount = unitMapper.findAll().size();
        unitMapper.insert(unitTestable.randomize(false));
        assertTrue(beforeElementsCount == unitMapper.findAll().size() - 1);
    }

    @Test
    public void find_correctObject_foundOne() {
        Unit before = unitTestable.randomize(false);
        unitMapper.insert(before);
        int id = before.getId();
        Unit after = unitMapper.find(id);
        assertTrue(before.equals(after));
    }

    @Test
    public void find_incorrectObject_returnedNull() {
        Unit found = unitMapper.find(INCORRECT_ID);
        assertTrue(found == null);
    }

    @Test
    public void findAll_objectInDb_foundMoreThanZero() {
        assertTrue(unitMapper.findAll().isEmpty());
        unitTestable.randomize(true);
        assertTrue(unitMapper.findAll().size() > 0);
    }

    @Test
    public void findAll_objectsNotInDb_returnedEmptyList() {
        unitMapper.deleteAll();
        assertTrue(unitMapper.findAll().isEmpty());
    }

    @Test
    public void deleteById_correctId_objectDeleted() {
        Unit item = unitTestable.randomize(false);
        unitMapper.insert(item);
        assertTrue(unitMapper.find(item.getId()) != null);
        unitMapper.deleteById(item.getId());
        assertTrue(unitMapper.find(item.getId()) == null);
    }

    @Test
    public void delete_correctObject_objectDeleted() {
        Unit item = unitTestable.randomize(true);
        assertTrue(unitMapper.find(item.getId()) != null);
        unitMapper.delete(item);
        assertTrue(unitMapper.find(item.getId()) == null);
    }

    @Test
    public void deleteAll_emptyDb() {
        unitTestable.randomize(true);
        assertTrue(!unitMapper.findAll().isEmpty());
        unitMapper.deleteAll();
        assertTrue(unitMapper.findAll().isEmpty());
    }
    
    @Test
    public void update_correctData_objectChanged(){
        Unit before = unitTestable.randomize(true);
        Unit toUpdate = before;
        toUpdate.setName("changedName");
        unitMapper.update(toUpdate);
        assertTrue(toUpdate.equals(unitMapper.find(toUpdate.getId())));
    }

}
