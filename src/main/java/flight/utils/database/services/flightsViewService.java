/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.database.services;

import flight.utils.domain.Flight;
import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tomkabp
 */

@ManagedBean(name="flightsVService")
@ApplicationScoped
public class flightsViewService {

    private static final String dbURL = "jdbc:derby://localhost:1527/flight_booking3-test;user=fb3;password=fb3";

    private static Connection conn = null;
    private static Statement sql = null;
    private static String result;

    public List<Flight> getFlights(String query) {
        createConnection();
        List<Flight> list = new ArrayList<Flight>();
        try {
            sql = conn.createStatement();
            ResultSet results = sql.executeQuery(query);
            ResultSetMetaData rsmd = results.getMetaData();

            while (results.next()) {
                int element1 = results.getInt(1);
                String element2 = results.getString(2);
                String element3 = results.getString(3);
                String element4 = results.getString(4);
                String element5 = results.getString(5);
                int element6 = results.getInt(6);
                Date element7 = results.getDate(7);
                Time element8 = results.getTime(8);
                Date element9 = results.getDate(9);
                Time element10 = results.getTime(10);
                int element11 = results.getInt(11);
                int element12 = results.getInt(12);
                int element13 = results.getInt(13);
                int element14 = results.getInt(14);

                list.add(new Flight(element1, element2, element3, element4, element5, element6, element7, element8, element9, element10, element11, element12, element13, element14));
            }
            results.close();
            sql.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        shutdown();
        return list;
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
}
