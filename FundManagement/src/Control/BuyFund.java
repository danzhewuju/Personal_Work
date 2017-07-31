package Control;

import DatabaseDao.FundDao;
import DatabaseDao.InvestDao;
import MiddleClass.Funds;
import MiddleClass.UserInvest;
import Page.Fund;
import Page.Invest;
import Page.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "BuyFund",value = "/BuyFund")
public class BuyFund extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String  fid= request.getParameter("fid");
        FundDao fundDao=new FundDao();
        Fund fund=fundDao.getFundBycolumn("fid",fid);
        User user= (User) request.getSession().getAttribute("user");
        java.util.Date date=new java.util.Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date);
        java.sql.Date today;
       today=new java.sql.Date(date.getTime());
        Invest invest=new Invest(user.getUid(),fund.getFid(),"日投",today,today,0,0,1,1000,0,0,1000,0,1);
        UserInvest userInvest= (UserInvest) request.getSession().getAttribute("userinvest");
        userInvest.addInvest(invest);//同步内存
        InvestDao investDao=new InvestDao();
        investDao.addInvest(invest);//写入数据库
        request.getSession().setAttribute("userinvest",userInvest);
        Funds funds= (Funds) request.getSession().getAttribute("funds");
        funds.delfund(fund);//内存同步
        request.getSession().setAttribute("funds",funds);
        response.sendRedirect("addfund.jsp");

    }
}
