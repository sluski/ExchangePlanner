package pl.slupski.view.TestBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.controller.services.ProductService;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@ManagedBean
@ViewScoped 
public class TestView {

    private Product newItem;
    
    @Autowired
    private ProductService productService;
    
    public TestView() {
        newItem = new Product();
    }
    
    public void add(){
        int id = productService.add(new Product(1, "tes", new Unit(1, "Kilogramy", "KG")));
        productService.find(id);
        List<Product> products = productService.findAll();
    }
    
    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public Product getNewItem() {
        return newItem;
    }

    public void setNewItem(Product newItem) {
        this.newItem = newItem;
    }
    
    

}
