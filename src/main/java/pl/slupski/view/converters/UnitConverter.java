package pl.slupski.view.converters;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.interfaces.ExchangeServiceInterface;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski
 */
@ManagedBean
@ViewScoped
@FacesConverter("unitConverter")
public class UnitConverter implements Converter {

    @Autowired
    private ExchangeServiceInterface exchangeService;

    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public Unit getAsObject(final FacesContext fc, final UIComponent uic, final String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return exchangeService.findUnit(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(final FacesContext fc, final UIComponent uic, final Object object) {
        if (object != null) {
            return String.valueOf(((Unit) object).getId());
        } else {
            return null;
        }
    }
}
