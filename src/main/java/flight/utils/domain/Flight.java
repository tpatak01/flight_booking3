/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.domain;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author tomkabp
 */
public class Flight {

    private final int fid;
    private final String fstatus;
    private final String from_ap;
    private final String to_ap;
    private final String airline_code;
    private final String flight_no;
    private final Date dep_date;
    private final Time dep_time;
    private final Date arr_date;
    private final Time arr_time;
    private final double seat_bus_cost;
    private final int seat_bus_left;
    private final double seat_eco_cost;
    private final int seat_eco_left;
    
    public Flight(int element1, String element2, String element3, String element4, String element5, int element6, Date element7, Time element8, Date element9, Time element10, int element11, int element12, int element13, int element14) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.fid = element1;
        this.fstatus = element2;
        this.from_ap = element3;
        this.to_ap = element4;
        this.airline_code = element5;
        this.flight_no = String.format("%03d", element6);
        this.dep_date = element7;
        this.dep_time = element8;
        this.arr_date = element9;
        this.arr_time = element10;
        this.seat_bus_cost = ((double)element11) / 100;
        this.seat_bus_left = element12;
        this.seat_eco_cost = ((double)element11) / 100;
        this.seat_eco_left = element14; 
    }

    public int getFid() {
        return fid;
    }

    public String getFstatus() {
        return fstatus;
    }

    public String getFrom_ap() {
        return from_ap;
    }

    public String getTo_ap() {
        return to_ap;
    }

    public String getAirline_code() {
        return airline_code;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public Date getDep_date() {
        return dep_date;
    }

    public Time getDep_time() {
        return dep_time;
    }

    public Date getArr_date() {
        return arr_date;
    }

    public Time getArr_time() {
        return arr_time;
    }

    public double getSeat_bus_cost() {
        return seat_bus_cost;
    }

    public int getSeat_bus_left() {
        return seat_bus_left;
    }

    public double getSeat_eco_cost() {
        return seat_eco_cost;
    }

    public int getSeat_eco_left() {
        return seat_eco_left;
    }
    
    
    
}
