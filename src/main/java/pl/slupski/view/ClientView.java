package pl.slupski.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.interfaces.ExchangeServiceInterface;
import pl.slupski.controller.pojo.Client;

/**
 *
 * @author Przemysław Słupski
 */
@ManagedBean
@ViewScoped
public class ClientView {

    @Autowired
    private ExchangeServiceInterface service;
    private List<Client> clients;
    private Client selected;
    private Client newItem;

    private void updateLists() {
        clients = service.findClients();
    }
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public Client getSelected() {
        return selected;
    }
    public void setSelected(Client selected) {
        this.selected = selected;
    }
    public Client getNewItem() {
        return newItem;
    }
    public void setNewItem(Client newItem) {
        this.newItem = newItem;
    }

    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        updateLists();
        newItem = new Client();
    }
}
