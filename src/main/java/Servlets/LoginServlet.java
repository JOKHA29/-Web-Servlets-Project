package Servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.User;
import DAO.UserDao;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("id") != null)
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (UserDao) getServletContext().getAttribute("UserDao");
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        int userID = dao.CheckUser(username,password);
        if(userID != -1){
            req.getSession().setAttribute("id",userID);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }
        else if(dao.CheckUsername(username)) req.getRequestDispatcher("WEB-INF/wrongPassword.jsp").forward(req, resp);
        else req.getRequestDispatcher("WEB-INF/wrongusername.jsp").forward(req, resp);
    }
}
