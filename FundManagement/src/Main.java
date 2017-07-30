import DatabaseDao.FundDao;
import DatabaseDao.InvestDao;
import DatabaseDao.UserDao;
import Page.Fund;
import Page.Invest;
import Page.User;
import net.sf.json.JSONObject;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alx on 2017/7/26.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

//
//        InvestDao investDao=new InvestDao();
//        List<Invest> invests=investDao.getInvestBycolumn("uid","10000","fid","100000");
//        System.out.println(invests.size());

//        FundDao fundDao=new FundDao();
//       Fund fund=new Fund();
//        fund.setName("天使基金");
//        fund.setPlatform("天使基金平台");
//        fund.setBallpark("大");
//        fund.setGrade(5);
//        fund.setBgrade(4);
//        fund.setManager("余豪");
//        fund.setMgrade(5);
 //       Fund fund1=fundDao.getFundBycolumn("fid","100003");
 //     fundDao.DelFund(fund1);
//        fundDao.AddFund(fund);

//        Date date=new Date(2017,7,21);
//      Invest invest=new Invest(1,10000,100000,"日投",date,date,12.0,25,1,12569,145,25,3654,145);InvestDao investDao=new InvestDao();
//       investDao.updateBycolumn(invest);
        User user=new User();
        user.setAccount(1000.0);
        user.setPassword("123456");
        user.setUid(1000);
        JSONObject jsonObject=JSONObject.fromObject(user);
        System.out.println(jsonObject.toString());

    }
}
