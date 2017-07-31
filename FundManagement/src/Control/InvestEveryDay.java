package Control;

import DatabaseDao.InvestDao;
import DatabaseDao.UserDao;
import MiddleClass.UserInvest;
import Page.Invest;
import Page.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;

/**
 * Created by Alx on 2017/7/30.
 */
@WebServlet(name = "InvestEveryDay",value = "/InvestEveryDay")
public class InvestEveryDay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date today,firstdate;
        double proalo;
        double getincome;
        double thisincome;
        double amount;
        double rifa;
        double invest;
        double firstyearincome;
        int count;
        String mode;

        UserInvest userInvest= (UserInvest) request.getSession().getAttribute("userinvest");
        Invest lastInvest= (Invest) request.getSession().getAttribute("lastinvest");
        mode=lastInvest.getMode();//模式
        int index=(Integer) request.getSession().getAttribute("investindex");
        count=userInvest.getInvestings().get(index).getCount()+1;
        today=Date.valueOf(request.getParameter("today"));
        firstdate=lastInvest.getFirstdate();//首年的投资
        invest=Double.valueOf(request.getParameter("invest"));
        proalo= Double.parseDouble(request.getParameter("proalo"));//持仓盈亏
        getincome=Double.valueOf(request.getParameter("getincome"));//实现盈利
        amount=Double.parseDouble(request.getParameter("amount"));//资产
        rifa=Double.parseDouble(request.getParameter("rifa"));//涨跌幅
        thisincome=(proalo-getincome)*0.95;//本轮盈利
        firstyearincome=thisincome/(amount-thisincome)*365;
        DecimalFormat df=new DecimalFormat("0.0000");
        firstyearincome=Double.valueOf(df.format(firstyearincome));
        Invest newinvest=new Invest(userInvest.getUser().getUid(),lastInvest.getFid(),mode,firstdate,today
                ,getincome,thisincome,count,amount,proalo,rifa,invest,firstyearincome,1);
        InvestDao investDao=new InvestDao();
        investDao.addInvest(newinvest);//写入数据库
        userInvest.addInvest(newinvest);//与内存进行同步
        response.sendRedirect("InvestEveryDay.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user= (User) request.getSession().getAttribute("user");
        if(user!=null)
        {
            UserInvest userInvest=new UserInvest(user);
            request.getSession().setAttribute("userinvest",userInvest);
            response.sendRedirect("InvestEveryDay.jsp");

        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
}
