package pl.slupski.model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.model.EntityToPojoConverter;
import pl.slupski.model.entiy.TProduct;
import pl.slupski.model.entiy.TUnit;
import pl.slupski.model.interfaces.StandardDaoInterface;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Repository
public class UnitDao implements StandardDaoInterface<Unit> {

    private final SessionFactory sessionFactory;
    private final EntityToPojoConverter entityToPojoConverter;

    public UnitDao(final SessionFactory sessionFactory, final EntityToPojoConverter entityToPojoConverter) {
        this.sessionFactory = sessionFactory;
        this.entityToPojoConverter = entityToPojoConverter;
    }

    @Override
    public int add(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unit find(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        return entityToPojoConverter.toUnit((TUnit) session.get(TProduct.class, id));
    }

    @Override
    public List<Unit> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
