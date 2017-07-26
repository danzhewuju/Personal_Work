package DatabaseDao;

import Entity.FundEntity;

import Page.Fund;
import Unit.HibernateUtils;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Alx on 2017/7/26.
 */
public class FundDao {


    public Fund getFundBycolumn(String column,String  key)
    {
        Fund fund=null;
        Session session= HibernateUtils.getSession();
        String hql="from FundEntity where "+column+"="+"'"+key+"'";
        List<FundEntity> f=session.createQuery(hql).list();
        if (f.size()>0)
        {
            fund=new Fund();
            fund.setFid(f.get(0).getFid());
            fund.setName(f.get(0).getName());
            fund.setPlatform(f.get(0).getPlatform());
            fund.setBallpark(f.get(0).getBallpark());
            fund.setGrade(f.get(0).getGrade());
            fund.setBgrade(f.get(0).getBgrade());
            fund.setManager(f.get(0).getManager());
            fund.setMgrade(f.get(0).getMgrade());

        }
        HibernateUtils.closeSession(session);
        return  fund;
    }

    public  void AddFund(Fund fund){
        boolean flag;

        FundEntity fundEntity=new FundEntity();
        fundEntity.setFid(fund.getFid());
        fundEntity.setName(fund.getName());
        fundEntity.setPlatform(fund.getPlatform());
        fundEntity.setBallpark(fund.getBallpark());
        fundEntity.setGrade(fund.getGrade());
        fundEntity.setBgrade(fund.getBgrade());
        fundEntity.setManager(fund.getManager());
        fundEntity.setMgrade(fund.getMgrade());
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        session.save(fundEntity);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
    }

    public  void DelFund(Fund fund)
    {
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        FundEntity fundEntity=session.load(FundEntity.class,fund.getFid());
        session.delete(fundEntity);
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
    }


}