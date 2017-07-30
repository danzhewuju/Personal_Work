package Control;

import MiddleClass.UserInvest;
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
@WebServlet(name = "CheckInvest",value = "/CheckInvest")
public class CheckInvest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     User user= (User) request.getSession().getAttribute("user");
     if(user!=null)
     {
         UserInvest userInvest=new UserInvest(user);
         request.getSession().setAttribute("userinvest",userInvest);
         response.sendRedirect("CheckInvest.jsp");

     }
     else {
         response.sendRedirect("login.jsp");
     }



    }
}
