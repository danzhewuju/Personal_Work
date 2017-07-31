package MiddleClass;

import DatabaseDao.FundDao;
import Page.Fund;

import java.util.ArrayList;

public class Funds {
   private   ArrayList <Fund> funds;
   private  int count;

    public Funds() {
        FundDao fundDao=new FundDao();
        funds=fundDao.getAllFund();
        count=funds.size();
    }

    public ArrayList<Fund> getFunds() {
        return funds;
    }

    public void setFunds(ArrayList<Fund> funds) {
        this.funds = funds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void delfund(Fund fund){
        for (Fund fund1:funds)
        {
            if(fund.getFid()==fund.getFid())
            {
                funds.remove(fund1);
                break;
            }
        }
        count--;
    }
    public  void  delfund(ArrayList<Integer> re)
    {
          ArrayList<Fund> funds1=new ArrayList<>();
        for(int i=0;i<re.size();i++)
        {
            funds1.add(funds.get(re.get(i)));
        }

        funds.removeAll(funds1);
        count=funds.size();
    }
}
