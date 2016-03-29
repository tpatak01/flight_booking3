/*
 * This application is created as an Assignment project.
 * The project required by Birkbeck University.
 */
package flight.utils.domain;

/**
 *
 * @author tomkabp
 */
public class acList {
    
    private int id;
    private String displayName;  
    private String searchName;
    
    public acList() {}
 
    public acList(int id, String displayName, String searchName) {
        this.id = id;
        this.displayName = displayName;
        this.searchName = searchName;     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    } 
    
    @Override
    public String toString() {
        return searchName;
    }
}