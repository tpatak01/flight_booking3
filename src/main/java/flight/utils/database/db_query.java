/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author tomkabp
 */
@ManagedBean
public class db_query {
    private static final String dbURL = "jdbc:derby://localhost:1527/flight_booking3-test;user=fb3;password=fb3";
    private static final String tableName = "airports";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement sql = null;
    
    private static String result;

    /*
    public db_query() {
        this.result = result;
    }
    */
    
    
    
    private static void createConnection() {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void shutdown() {
        try
        {
            if (sql != null)
            {
                sql.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }

    public static String getResult() {
        createConnection();
        try
        {
            sql = conn.createStatement();
            ResultSet results = sql.executeQuery("select airport from airports where iata='LHR'");
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next())
            {              
                result  = results.getString(1);                
            }
            results.close();
            sql.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        
        return result;
    }
    
    

    
}
