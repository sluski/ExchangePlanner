package pl.slupski.view.TestBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import pl.slupski.controller.interfaces.UnitServiceInterface;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.controller.services.UnitService;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@ManagedBean
@ViewScoped
public class UnitView {

    @Autowired
    private UnitService unitService;
    
    private int unitIdToFind;
    private int unitIdToDelete;
    private Unit newUnit;
    private Unit selectedUnit;

    public UnitView() {
        selectedUnit = new Unit();
        newUnit = new Unit();
    }

    
    
    @PostConstruct
    public void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public void add() {
        unitService.add(newUnit);
    }

    public void find() {
       unitService.find(unitIdToFind);
    }
    
    public List<Unit> findAll(){
        return unitService.findAll();
    }

    public void delete() {
        unitService.delete(selectedUnit);
    }

    public void deleteById() {
        unitService.delete(unitIdToDelete);
    }

    public int getUnitIdToFind() {
        return unitIdToFind;
    }

    public void setUnitIdToFind(int unitIdToFind) {
        this.unitIdToFind = unitIdToFind;
    }

    public int getUnitIdToDelete() {
        return unitIdToDelete;
    }

    public void setUnitIdToDelete(int unitIdToDelete) {
        this.unitIdToDelete = unitIdToDelete;
    }

    public Unit getNewUnit() {
        return newUnit;
    }

    public void setNewUnit(Unit newUnit) {
        this.newUnit = newUnit;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }


}
