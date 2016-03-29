/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.database.services;

import java.util.ArrayList;
import java.util.List; 
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import flight.utils.domain.acList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author tomkabp
 */ 
@ManagedBean(name="acListService", eager = true)
@ApplicationScoped
public class acListService {
    
    private static final String dbURL = "jdbc:derby://localhost:1527/flight_booking3-test;user=fb3;password=fb3";
    
    private static Connection conn = null;
    private static Statement sql = null;
    //private static String result;
    public List<acList> AClist;
    
    @PostConstruct
    public void init() {
        createConnection();
        List<acList> list = new ArrayList<acList>();
        String query = "SELECT * FROM airports";
        try {
            sql = conn.createStatement();
            ResultSet results = sql.executeQuery(query);
            ResultSetMetaData rsmd = results.getMetaData();
            int counter = 0;
            while (results.next()) {
                
                String element1 = results.getString(1);
                String element2 = results.getString(2);
                String element3 = results.getString(3);
                String element4 = results.getString(4);
                
                String text1 =  element1 + " - " + element2 + ", " + element3 + ", " + element4;
                String text2 = (element1 + element2 + element3 + element4).toLowerCase();

                list.add(new acList(counter, text1, text2));
                counter = counter ++;
            }
            results.close();
            sql.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        shutdown();
        this.AClist = list;
    }
        
    
    public List<acList> getAClist(){        
        return AClist;
    }
    
    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static void shutdown() {
        try {
            if (sql != null) {
                sql.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "acListService{" + "AClist=" + AClist + '}';
    }
    
    
}
