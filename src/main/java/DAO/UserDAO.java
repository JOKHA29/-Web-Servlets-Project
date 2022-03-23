package DAO;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public void add(User user) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO users VALUES(?, ?);");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            boolean added = st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean checkUser(User user) {
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE username = ? and pwd = ?;");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            ResultSet res = st.executeQuery();
            return res.next();
        } catch (SQLException e) {}
        return false;
    }

    public boolean checkUsername(String userName) {
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE username = ?;");
            st.setString(1, userName);
            ResultSet res = st.executeQuery();
            return res.next();
        } catch (SQLException e) {}
        return false;
    }

}
