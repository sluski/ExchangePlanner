package pl.slupski.model.interfaces;

import java.util.List;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public interface StandardDaoInterface<T> {
    public int add(T item);
    public T find(int id);
    public List<T> findAll();
    public void update(T item);
    public void delete(int id);
    public void delete(T item);
}
