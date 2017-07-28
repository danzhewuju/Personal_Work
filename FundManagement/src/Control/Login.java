package Control;

import DatabaseDao.UserDao;
import Page.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alx on 2017/7/28.
 */
@WebServlet(name = "Login",value = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myusername=request.getParameter("myusername");
        String mypassword=request.getParameter("mypassword");
        UserDao userDao=new UserDao();
        User user=userDao.getUserBycolumn("uid",myusername);
        if(user.getPassword().equals(mypassword))
        {
            request.getSession().setAttribute("user",user);
            response.sendRedirect("menu.jsp");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
