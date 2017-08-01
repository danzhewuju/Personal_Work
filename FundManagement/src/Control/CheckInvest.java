package Control;

import MiddleClass.FundInvest;
import MiddleClass.JsonIncome;
import MiddleClass.JsonUserIncome;
import MiddleClass.UserInvest;
import Page.User;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
//开始获取脚本json的相关数据
         if(userInvest.getCount()>0)
         {
             ArrayList<JsonIncome> jsonIncomes=new ArrayList<>();
             for(FundInvest fundInvest:userInvest.getInvestings())
             {
                 JsonIncome jsonIncome=new JsonIncome();
                 jsonIncome.setFid(fundInvest.getFund().getFid());
                 jsonIncome.setFname(fundInvest.getFund().getName());
                 jsonIncome.setDates(fundInvest.getJsonDate());
                 jsonIncome.setInvestingincome(fundInvest.getjsondayprofit());
                 jsonIncome.setAmount(fundInvest.getInvestings().get(fundInvest.getCount()-1).getAmount());
                 jsonIncomes.add(jsonIncome);
             }
             JsonUserIncome jsonUserIncome=new JsonUserIncome(jsonIncomes);
//             JsonConfig cfg = new JsonConfig();
//
//             cfg.setExcludes(new String[]{"handler","hibernateLazyInitializer"});

             JSONObject jsonObject=JSONObject.fromObject(jsonUserIncome);
             String json=jsonObject.toString();
             request.getSession().setAttribute("json",json);
         }


         response.sendRedirect("CheckInvest.jsp");

     }
     else {
         response.sendRedirect("login.jsp");
     }



    }
}
