package DatabaseDao;

import Entity.FundEntity;
import Entity.InvestEntity;
import Entity.UserEntity;
import Page.Fund;
import Page.Invest;
import Page.User;
import Unit.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alx on 2017/7/26.
 */
public class InvestDao {

    public Invest InvestEntitytoInvest(InvestEntity investEntity) {

        Invest invest = new Invest();
        invest.setIid(investEntity.getIid());
        invest.setUid(investEntity.getUid());
        invest.setFid(investEntity.getFid());
        invest.setMode(investEntity.getMode());
        invest.setFirstdate(investEntity.getFirstdate());
        invest.setToday(investEntity.getToday());
        invest.setGetincome(investEntity.getGetincome());
        invest.setThisincome(investEntity.getThisincome());
        invest.setCount(investEntity.getCount());
        invest.setAmount(investEntity.getAmount());
        invest.setProalo(investEntity.getProalo());
        invest.setRifa(investEntity.getRifa());
        invest.setInvest(investEntity.getInvest());
        invest.setFirstyearprofit(investEntity.getFirstyearprofit());
        invest.setBsale(investEntity.getBsale());
        return  invest;

    }
    public  InvestEntity InvesttoInvestEntity(Invest invest)
    {

        InvestEntity investEntity=new InvestEntity();
        investEntity.setIid(invest.getIid());
        investEntity.setUid(invest.getUid());
        investEntity.setFid(invest.getFid());
        investEntity.setMode(invest.getMode());
        investEntity.setFirstdate(invest.getFirstdate());
        investEntity.setToday(invest.getToday());
        investEntity.setGetincome(invest.getGetincome());
        investEntity.setThisincome(invest.getThisincome());
        investEntity.setCount(invest.getCount());
        investEntity.setAmount(invest.getAmount());
        investEntity.setProalo(invest.getProalo());
        investEntity.setRifa(invest.getRifa());
        investEntity.setInvest(invest.getInvest());
        investEntity.setFirstyearprofit(invest.getFirstyearprofit());
        investEntity.setBsale(invest.getBsale());

        return  investEntity;


    }



    public List<Invest> getInvestBycolumn(String column, String key) {
        List<Invest> invests = new ArrayList<>();
        Session session = HibernateUtils.getSession();
        String hql = " from InvestEntity where " + column + "=" + "'" + key + "'";
        List<InvestEntity> investEntities = session.createQuery(hql).list();
        for (InvestEntity investEntity : investEntities) {
            Invest invest = InvestEntitytoInvest(investEntity);

            invests.add(invest);
        }
        HibernateUtils.closeSession(session);
        return invests;

    }

    public List<Invest> getInvestBycolumn(String column1, String key1, String column2, String key2) {
        List<Invest> invests = new ArrayList<>();
        Session session = HibernateUtils.getSession();
        String hql = " from InvestEntity where " + column1 + "=" + "'" + key1 + "'" + " and " + column2 + "=" + "'" + key2 + "'";
        List<InvestEntity> investEntities = session.createQuery(hql).list();
        for (InvestEntity investEntity : investEntities) {
            Invest invest = InvestEntitytoInvest(investEntity);
            invests.add(invest);
        }
        HibernateUtils.closeSession(session);
        return invests;

    }

    public boolean updateBycolumn(Invest invest) {
        boolean flag = false;
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            InvestEntity investEntity=InvesttoInvestEntity(invest);
            UserEntity userEntity=session.get(UserEntity.class,invest.getUid());
            investEntity.setUserByUid(userEntity);
            FundEntity fundEntity=session.get(FundEntity.class,invest.getFid());
            investEntity.setFundByFid(fundEntity);
            session.update(investEntity);
            session.getTransaction().commit();
            flag=true;
        } catch (Exception e)
        {

            flag=false;
        }
        finally {
            HibernateUtils.closeSession(session);
        }








        return  flag;

    }

public  boolean addInvest(Invest invest)
{
    boolean flag;
    Session session=HibernateUtils.getSession();
    try
    {   session.beginTransaction();
        InvestEntity investEntity=InvesttoInvestEntity(invest);
        UserEntity userEntity=session.get(UserEntity.class,invest.getUid());
        investEntity.setUserByUid(userEntity);
        FundEntity fundEntity=session.get(FundEntity.class,invest.getFid());
        investEntity.setFundByFid(fundEntity);
        session.save(investEntity);
        session.getTransaction().commit();
        flag=true;

    }
    catch (Exception e)
    {
        session.getTransaction().rollback();
        flag=false;
    }finally {
        HibernateUtils.closeSession(session);
    }
   return flag;


}

    public  List<Fund> getFund(User user )
    {
        List<Fund> funds=new ArrayList<>();
        Session session=HibernateUtils.getSession();
        String hql=" from InvestEntity where uid=:uid group by fid ";
       Query query=session.createQuery(hql).setParameter("uid",user.getUid());
        List<InvestEntity> investEntities=query.list();
        FundDao fundDao=new FundDao();
        for(InvestEntity investEntity:investEntities)
        {
            Fund fund=fundDao.getFundBycolumn("fid", String.valueOf(investEntity.getFid()) );
            funds.add(fund);
        }
        HibernateUtils.closeSession(session);
        return  funds;


    }






}
