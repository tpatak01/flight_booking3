/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import flight.utils.domain.acList;
import flight.utils.database.services.acListService;

/**
 *
 * @author tomkabp
 */
@ManagedBean
public class AutoComplete {
    
    private acList acList;
    private List<acList> selectedAcLists;
    
    @ManagedProperty("#{acListService}")
    private acListService service;

    public acList getAcList() {
        return acList;
    }

    public void setAcList(acList acList) {
        this.acList = acList;
    }
    
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
    
    public void setSelectedThemes(List<acList> selectedAcLists) {
        this.selectedAcLists = selectedAcLists;
    }
     
    public void setService(acListService service) {
        this.service = service;
    }
 
    public char getAcListGroup(acList acList) {
        return acList.getDisplayName().charAt(0);
    }
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
     
    public List<acList> completeAC(String query) {
        List<acList> allAC = service.getAClist();
        List<acList> filteredAC = new ArrayList<acList>();
         
        for (int i = 0; i < allAC.size(); i++) {
            acList skin = allAC.get(i);
            if(skin.toString().toLowerCase().startsWith(query)) {
                filteredAC.add(skin);
            }
        }
         
        return filteredAC;
    }
    
}
