package Servlets;

import DAO.UserDAO;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class login extends HttpServlet {
    private UserDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao = (UserDAO) getServletContext().getAttribute("userDAO");
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        if(dao.checkUser(new User(username,password))) request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
        else if(dao.checkUsername(username))request.getRequestDispatcher("WEB-INF/wrongPassword.jsp").forward(request, response);
        else request.getRequestDispatcher("WEB-INF/wrongusername.jsp").forward(request, response);

    }
}
