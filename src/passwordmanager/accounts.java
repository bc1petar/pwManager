package passwordmanager;

import java.io.Serializable;

public class accounts implements Serializable{
    
    private String username,description,password;

    private String key;

    public accounts(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
           
    public accounts(String username, String description, String password) {
        this.username = username;
        this.description = description;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getPassword() {
        return password;
    }         
}
