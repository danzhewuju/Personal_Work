package MiddleClass;

import DatabaseDao.InvestDao;
import Page.Fund;
import Page.Invest;
import Page.User;

import java.util.ArrayList;

/**
 * Created by Alx on 2017/7/28.
 */
public class UserInvest {//用户的投资情况
    private User user;//用户
    private ArrayList<FundInvest> allinvests;//用户的所有投资基金的总和
    private int allcount;//用户投资过的基金总和
    private ArrayList<FundInvest> investings;//用户还在投资的基金
    private int count;//用户还在投资的基金数
    private double ammount;//用户的所有基金所有资产


    public UserInvest(User user) {
        this.user = user;
        ammount=0;
        InvestDao investDao=new InvestDao();
        ArrayList<Fund> funds= (ArrayList<Fund>) investDao.getFund(user);
        allinvests=new ArrayList<>();
        for(Fund fund:funds)
        {
            FundInvest fundInvest=new FundInvest(fund,user);
            allinvests.add(fundInvest);
        }
        allcount=allinvests.size();//全部的基金的相关信息
        setInvestings();//获得正在投资的基金的相关信息


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<FundInvest> getAllinvest() {
        return allinvests;
    }

    public void setAllinvest(ArrayList<FundInvest> allinvest) {
        this.allinvests= allinvest;
    }
    public void setAllinvest() {
        InvestDao investDao=new InvestDao();
        ArrayList<Fund> funds= (ArrayList<Fund>) investDao.getFund(user);//获取已有用户的基金列表
        allinvests=new ArrayList<>();
        for(Fund fund:funds)
        {
            FundInvest fundInvest=new FundInvest(fund,user);
            allinvests.add(fundInvest);
        }
        allcount=allinvests.size();//全部的基金的相关信息
    }

    public int getAllcount() {
        return allcount;
    }

    public void setAllcount(int allcount) {
        this.allcount = allcount;
    }

    public ArrayList<FundInvest> getInvestings() {
        return investings;
    }

    public void setInvestings(ArrayList<FundInvest> investings) {
        this.investings = investings;
    }
    public void setInvestings() {
        investings=new ArrayList<>();
        ammount=0;
        for(FundInvest fundInvest:allinvests)
        {
            if (fundInvest.getCount()>0)
            {
                investings.add(fundInvest);
                ammount+=fundInvest.getProfit();
            }
        }
        count=investings.size();

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public ArrayList<FundInvest> getAllinvests() {
        return allinvests;
    }

    public void setAllinvests(ArrayList<FundInvest> allinvests) {
        this.allinvests = allinvests;
    }

    public  void addInvest(Invest invest)//将一笔交易加入整个系统中
    {


        for (int i = 0; i < count; i++) {
            if (investings.get(i).getFund().getFid() == invest.getFid()) {
                investings.get(i).addInvesting(invest);//如果是追加的投资就会加入正在投资里面
                break;
            }
            if (i == count - 1)//最后没有表明是对该基金的第一次投资
            {
                for (int j = 0; j < allcount; j++) {
                    FundInvest fundInvest = allinvests.get(j);

                    if (fundInvest.getFund().getFid() == invest.getFid()) {
                        investings.add(fundInvest);
                        count++;
                        break;
                    }
                    if (j == allcount - 1) {//直接从数据库更新
                        setAllinvest();
                        setInvestings();
                    }
                }
            }


        }

    }
    public  void salefund(Fund fund)
    {
        for(FundInvest fundInvest:investings)
        {
            if(fund.getFid()==fundInvest.getFund().getFid())
            {
                fundInvest.saleFund(fund);
                investings.remove(fundInvest);
                count--;
                break;

            }
        }//修改正在投资里面的参数
        setAllinvest();


    }
}
