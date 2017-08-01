package Control;

import DatabaseDao.FundDao;
import DatabaseDao.InvestDao;
import MiddleClass.UserInvest;
import Page.Fund;
import Page.Invest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaleFund",value = "/SaleFund")
public class SaleFund extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String  fid=request.getParameter("fid");
        FundDao fundDao=new FundDao();
        Fund fund=fundDao.getFundBycolumn("fid",fid);
        UserInvest userInvest= (UserInvest) request.getSession().getAttribute("userinvest");
        userInvest.salefund(fund);
        request.getSession().setAttribute("userinvest",userInvest);
        response.sendRedirect("SaleFund.jsp");




    }
}
