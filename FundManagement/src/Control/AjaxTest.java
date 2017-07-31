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
        Invest invest = null;

       for(int i=0;i<userInvest.getCount();i++)
       {
           if(fid==userInvest.getInvestings().get(i).getFund().getFid())
           {
               int count=userInvest.getInvestings().get(i).getCount();
               invest=userInvest.getInvestings().get(i).getAllinvests().get(count-1);
               request.getSession().setAttribute("investindex",i);//记录选择基金的索引
               break;
           }
       }
       request.getSession().setAttribute("lastinvest",invest);

       String investjson="{invest:"+invest.getInvest()+",firstdate:"+"'"+invest.getFirstdate()+"'"+"}";
       System.out.println(investjson);
       response.getWriter().write(investjson);









    }
}
