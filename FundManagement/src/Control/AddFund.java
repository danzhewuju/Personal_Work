package Control;

import DatabaseDao.FundDao;
import Page.Fund;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alx on 2017/7/30.
 */
@WebServlet(name = "AddFund",value = "/AddFund")
public class AddFund extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name,platform,ballpark,manager;
        int grade,bgrade,mgrade;
        name=request.getParameter("name");
        platform=request.getParameter("platform");
        ballpark=request.getParameter("ballpark");
        manager=request.getParameter("manager");
        grade=Integer.valueOf(request.getParameter("grade"));
        bgrade=Integer.valueOf(request.getParameter("bgrade"));
        mgrade=Integer.valueOf(request.getParameter("mgrade"));//相参数的获取

        Fund fund=new Fund(name,platform,ballpark,grade,bgrade,manager,mgrade);
        FundDao fundDao=new FundDao();
      boolean flag= fundDao.AddFund(fund);
      String message=null;
      if (flag)
      {
          message="添加成功过";
      }
      else
      {
          message="添加失败，可能是添加了重复的基金";
      }
      request.getSession().setAttribute("message",message);
        response.sendRedirect("addfund.jsp");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
