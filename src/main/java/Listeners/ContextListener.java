package Listeners;

import DAO.UserDao;
import Info.Info;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PreparedStatement prd=null;
        Connection con=null;
        try {
            con = DriverManager.getConnection(Info.HOST, Info.USER, Info.PASSWORD);
            prd = con.prepareStatement("use tkt");
            prd.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        UserDao dao = new UserDao(con);
        servletContextEvent.getServletContext().setAttribute("UserDao",dao);
        System.out.println(servletContextEvent.getServletContext().getAttribute("UserDao"));

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
