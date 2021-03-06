/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils;

/**
 *
 * @author tomkabp
 */
import java.util.ArrayList;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import flight.utils.Theme;
import flight.utils.domain.acList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
    
    private static final String dbURL = "jdbc:derby://localhost:1527/flight_booking3-test;user=fb3;password=fb3";    
    private static Connection conn = null;
    private static Statement sql = null;
     
    private List<Theme> themes;
     
    @PostConstruct
    public void init() {
        
        themes = new ArrayList<Theme>();
        themes.add(new Theme(0, "Afterdark", "afterdark"));
        themes.add(new Theme(1, "Afternoon", "afternoon"));
        themes.add(new Theme(2, "Afterwork", "afterwork"));
        themes.add(new Theme(3, "Aristo", "aristo"));
        themes.add(new Theme(4, "Black-Tie", "black-tie"));
        themes.add(new Theme(5, "Blitzer", "blitzer"));
        themes.add(new Theme(6, "Bluesky", "bluesky"));
        themes.add(new Theme(7, "Bootstrap", "bootstrap"));
        themes.add(new Theme(8, "Luton, London", "ltnLutonLondon"));
        /*
        createConnection();
        //List<Theme> list = new ArrayList<Theme>();
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

                themes.add(new Theme(counter, text1, text2));
                counter = counter ++;
            }
            results.close();
            sql.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        shutdown();     */   
        
    }
     
    public List<Theme> getThemes() {
        return themes;
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
        return "ThemeService{" + "themes=" + themes + '}';
    }
    
    
}