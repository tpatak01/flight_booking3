/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.database;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import flight.utils.database.services.flightsSalesService;
import flight.utils.domain.Flight;

/**
 *
 * @author tomkabp
 */
@ManagedBean(name="dtsellingView")
@ViewScoped
public class salesSelling implements Serializable {
    
    private static String query = "select * from sales_selling";
    private List<Flight> flights;
     
    @ManagedProperty("#{salesService}")
    private flightsSalesService service;
 
    @PostConstruct
    public void init() {
        flights = service.getFlights(query);
    }
     
    public List<Flight> getFlights() {
        return flights;
    }
 
    public void setService(flightsSalesService service) {
        this.service = service;
    }
    
}