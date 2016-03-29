/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.application.FacesMessage;

import flight.utils.domain.acList;
import flight.utils.database.services.acListService;
/**
 *
 * @author tomkabp
 */
@FacesConverter("listConverter")
public class listConverter implements Converter {
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                acListService service = (acListService) fc.getExternalContext().getApplicationMap().get("acListService");
                return service.getAClist().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
    
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        
        if(object != null) {
            return String.valueOf(((acList) object).getId());
        }
        else {
            return null;
        }
    } 
    
}
