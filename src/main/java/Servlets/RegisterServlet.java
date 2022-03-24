package Servlets;

import DAO.User;
import DAO.UserDao;
import MailSender.MailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    private UserDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(getServletContext().getAttribute("id") == null)
            req.getRequestDispatcher("WEB-INF/register.jsp").forward(req,resp);
        else
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (UserDao) getServletContext().getAttribute("UserDao");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        String gmail=req.getParameter("email");
        if(dao.CheckUsername(username)){
        req.getRequestDispatcher("WEB-INF/alreadyExist.jsp").forward(req, resp);}
        else { dao.adduser(new User(username, password, gmail));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            MailSender.sendMail(gmail,"tkt","thank you for using our website");
        }
    }
}
