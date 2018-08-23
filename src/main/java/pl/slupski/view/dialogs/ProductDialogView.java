package pl.slupski.view.dialogs;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.interfaces.ExchangeServiceInterface;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski
 */
@ManagedBean
@ViewScoped
public class ProductDialogView {

    @Autowired
    private ExchangeServiceInterface service;
    private List<Unit> units;
    private Product newItem;
    private String actionName;

    public void updateLists() {
        units = service.findUnits();
    }

    public void onClickAdd() {
        service.insert(newItem);
        onClickCancel();
    }

    public void onClickCancel() {
        newItem = new Product();
    }

    public List<Unit> getUnits() {
        return units;
    }
    public void setUnits(final List<Unit> units) {
        this.units = units;
    }
    public Product getNewItem() {
        return newItem;
    }
    public void setNewItem(final Product newItem) {
        this.newItem = newItem;
    }
    public String getActionName() {
        return actionName;
    }
    public void setActionName() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.actionName = getParam(fc);
    }

    public String getParam(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("clickActionName");

    }

    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        updateLists();
        newItem = new Product();
    }

}
