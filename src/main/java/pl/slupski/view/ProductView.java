package pl.slupski.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.interfaces.ExchangeServiceInterface;
import pl.slupski.controller.pojo.Product;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@ManagedBean
@ViewScoped
public class ProductView {

    @Autowired
    private ExchangeServiceInterface exchangeService;

    private Product selected;
    private List<Product> products;

    public void updateLists() {
        products = exchangeService.findProducts();
    }

    public void onClickDelete() {
        exchangeService.delete(selected);
    }

    public Product getSelected() {
        return selected;
    }
    public void setSelected(final Product selected) {
        this.selected = selected;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        updateLists();
    }
}
