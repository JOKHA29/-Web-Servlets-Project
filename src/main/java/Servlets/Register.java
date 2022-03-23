package Servlets;

import DAO.UserDAO;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/register")
public class Register extends HttpServlet {
    private UserDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/register.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dao = (UserDAO) getServletContext().getAttribute("userDAO");

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        if(dao.checkUsername(username)) request.getRequestDispatcher("WEB-INF/alreadyExist.jsp").forward(request, response);
        else dao.add(new User(username,password));
    }

}
