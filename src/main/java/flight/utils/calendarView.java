/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.utils;


public class calendarView {
    
}
/**
 *
 * @author tomkabp
 



import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class calendarView {
         
    private Date dateDep;
    private Date dateArr;
        
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        //requestContext.execute("PF('dlg').show()");
    }
 
    public Date getDateDep() {
        return dateDep;
    }
 
    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }
 
    public Date getDateArr() {
        return dateArr;
    }
 
    public void setDateArr(Date dateArr) {
        this.dateArr = dateArr;
    }
 
}
*/