package DatabaseDao;

import Entity.InvestEntity;
import Page.Invest;
import Unit.HibernateUtils;
import org.hibernate.Session;

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
        return  invest;

    }
    public  InvestEntity InvesttoInvestEntity(Invest invest)
    {
       Session session=HibernateUtils.getSession();
       InvestEntity investEntity=session.load(InvestEntity.class,invest.getIid());
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
        investEntity.setFirstdate(invest.getFirstdate());
        HibernateUtils.closeSession(session);
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
        if (invest != null) {
            Session session = HibernateUtils.getSession();
            session.beginTransaction();
           InvestEntity investEntity=InvesttoInvestEntity(invest);
           session.update(investEntity);
           session.getTransaction().commit();
           flag=true;
        } else {
             flag=false;
        }
        return  flag;

    }


}
