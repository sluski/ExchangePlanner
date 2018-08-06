package pl.slupski.model.dao;

import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.EntityToPojoConverter;
import pl.slupski.model.entiy.TProduct;
import pl.slupski.model.interfaces.ProductDaoInterface;
import pl.slupski.model.interfaces.StandardDaoInterface;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Repository
public class ProductDao implements ProductDaoInterface {

    private final SessionFactory sessionFactory;
    private final EntityToPojoConverter entityToPojoConverter;

    public ProductDao(final SessionFactory sessionFactory, final EntityToPojoConverter entityToPojoConverter) {
        this.sessionFactory = sessionFactory;
        this.entityToPojoConverter = entityToPojoConverter;
    }

    @Override
    public int add(final Product item) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        int id = (Integer) session.save(new TProduct(item));
        session.getTransaction().commit();
        return id;
    }

    @Override
    public Product find(final int id) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        return entityToPojoConverter.toProduct((TProduct) session.get(TProduct.class, id));
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        return (List<Product>) session.createQuery("from " + TProduct.SIMPLE_CLASS_NAME).
                list().stream().map(t -> entityToPojoConverter.toProduct((TProduct) t)).collect(Collectors.toList());
    }

    @Override
    public void update(final Product item) {
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
