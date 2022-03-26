package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
    public void adduser(User user){
        try {  PreparedStatement pr=con.prepareStatement("Insert into users values(?,?,?);");
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getPass());
            pr.setString(3, user.getGmail());
            pr.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
   public boolean CheckUserbyall(User user){
       try {
           PreparedStatement pr=con.prepareStatement("select * from users where username = ? and " +
                   "pass = ? and gmail=?;");
           pr.setString(1, user.getUsername());
           pr.setString(2, user.getPass());
           pr.setString(3, user.getGmail());
           ResultSet rs=pr.executeQuery();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       } return false;

   }
   public int CheckUser(String username, String password){
       try {
           PreparedStatement pr=con.prepareStatement("select * from users where username=? and pass=?;");
           pr.setString(1, username);
           pr.setString(2, password);
           ResultSet rs=pr.executeQuery();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }return -1;
   }
   public boolean CheckUsername(String username){
       try {
           PreparedStatement pr = con.prepareStatement("select username from users where username = ?;");
           pr.setString(1, username);
           ResultSet rs = pr.executeQuery();
           return rs.next();
       } catch (SQLException e) {

       }
       return false;
   }
// kk
}
