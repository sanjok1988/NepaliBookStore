
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sanjok
 */
public class Auth {
    
    Connect db = new Connect();
    
    public boolean auth(String username, String password){
        try{
           PreparedStatement pstmt= db.con.prepareStatement("select * from users where username=? and password=?");
           pstmt.setString(1, username);
           pstmt.setString(2, password);
           
           ResultSet rs=pstmt.executeQuery();
           
           if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
}
