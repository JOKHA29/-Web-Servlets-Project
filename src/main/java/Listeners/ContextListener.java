package Listeners;

import DAO.UserDAO;
import Util.Info;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection(Info.HOST, Info.USER, Info.PASSWORD);
            st = con.prepareStatement("USE users;");
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserDAO dao = new UserDAO(con);
        System.out.println(dao);
        servletContextEvent.getServletContext().setAttribute("userDAO",dao);
        System.out.println(servletContextEvent.getServletContext().getAttribute("userDAO"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
