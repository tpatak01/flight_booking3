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
import flight.utils.database.services.flightsViewService;
import flight.utils.domain.Flight;

/**
 *
 * @author tomkabp
 */

@ManagedBean(name="dtActiveView")
@ViewScoped
public class flightsViewActive implements Serializable {
    
    private static final String query = "select * from flights_active";
    private List<Flight> flights;
     
    @ManagedProperty("#{flightsVService}")
    private flightsViewService service;
 
    @PostConstruct
    public void init() {
        flights = service.getFlights(query);
    }
     
    public List<Flight> getFlights() {
        return flights;
    }
 
    public void setService(flightsViewService service) {
        this.service = service;
    }
    
}