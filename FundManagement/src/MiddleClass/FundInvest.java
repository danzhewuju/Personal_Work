package MiddleClass;

import DatabaseDao.InvestDao;
import Page.Fund;
import Page.Invest;
import Page.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alx on 2017/7/28.
 */
public class FundInvest {//每个基金的投资次数
    static private User user;
    private Fund fund;
    private List<Invest> allinvests;//用户在该基金的所有投资，包含卖出
    private int allcount;//该基金的总共投资次数
    private List<Invest> investings;//用户正在投资的基金操作
    private int count;//正在投资基金的投资总数
    private double profit;//该基金的盈利


    public FundInvest(Fund fund, User user) {
        this.fund = fund;
        this.user=user;
        setAllinvests();//从数据库读取相关信息 allinvest,allcount
        setInvestings();//获得当前该基金的投资情况
        profit=getInvestings().get(getCount()-1).getThisincome();//本轮盈利




    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Invest> getAllinvests() {
        return allinvests;
    }

    public void setAllinvests(ArrayList<Invest> allinvests) {
        this.allinvests = allinvests;
    }
//函数重载
    public void setAllinvests() {
        InvestDao investDao=new InvestDao();
        allinvests= (ArrayList<Invest>) investDao.getInvestBycolumn("uid", String.valueOf(user.getUid()) ,"fid",String.valueOf(fund.getFid()));
        allcount=allinvests.size();

    }
    public int getAllcount() {
        return allcount;
    }

    public void setAllcount(int allcount) {
        this.allcount = allcount;
    }

    public List<Invest> getInvestings() {
        return investings;
    }

    public void setinvestings(ArrayList<Invest> investing) {
        this.investings = investing;
    }

    public void setInvestings() {
        investings =new ArrayList<>();
        for(Invest invest:allinvests)
        {
           if(invest.getBsale()==1)
           {
               investings.add(invest);
           }
        }
        count=investings.size();
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        FundInvest.user = user;
    }

    public void setAllinvests(List<Invest> allinvests) {
        this.allinvests = allinvests;
    }

    public void setInvestings(List<Invest> investing) {
        this.investings = investing;
    }

}
