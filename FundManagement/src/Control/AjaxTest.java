package Control;

import MiddleClass.UserInvest;
import Page.Invest;
import Page.User;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alx on 2017/7/30.
 */
@WebServlet(name = "AjaxTest",value = "/AjaxTest")
public class AjaxTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");

       int fid=Integer.valueOf(request.getParameter("fid"));
        UserInvest userInvest= (UserInvest) request.getSession().getAttribute("userinvest");
        double invest=5000.0;

       for(int i=0;i<userInvest.getCount();i++)
       {
           if(fid==userInvest.getInvestings().get(i).getFund().getFid())
           {
               int count=userInvest.getInvestings().get(i).getCount();
               invest=userInvest.getInvestings().get(i).getAllinvests().get(count-1).getInvest();
               break;
           }
       }

       response.getWriter().write(String.valueOf(invest));









    }
}
