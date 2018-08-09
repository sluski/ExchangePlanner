package pl.slupski.controller.interfaces;

import java.util.List;
import pl.slupski.controller.pojo.Client;
import pl.slupski.controller.pojo.Order;
import pl.slupski.controller.pojo.OrderItem;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public interface ExchangeServiceInterface {
    
    public int insert(Client item);
    public Client findClient(int id);
    public List<Client> findClients();
    public void update(Client item);
    public void delete(Client item);
    
    
    public int insert(Order order);
    public Order findOrder(int id);
    public List<Order> findOrders();
    public void update(Order item);
    public void delete(Order item);
    
    public int insert(OrderItem orderItem);
    public OrderItem findOrderItem(int id);
    public List<OrderItem> findOrderItems();
    public void update(OrderItem item);
    public void delete(OrderItem item);
    
    public int insert(Product product);
    public Product findProduct(int id);
    public List<Product> findProducts();
    public void update(Product item);
    public void delete(Product item);
    
    public int insert(Unit unit);
    public Unit findUnit(int id);
    public List<Unit> findUnits();
    public void update(Unit item);
    public void delete(Unit item);
}
