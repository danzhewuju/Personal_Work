import DatabaseDao.FundDao;
import DatabaseDao.UserDao;
import Page.Fund;
import Page.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

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


        UserDao userDao=new UserDao();
        User user=userDao.getUserBycolumn("uid","10000");
        System.out.println(user.getUid());

        FundDao fundDao=new FundDao();
       Fund fund=new Fund();
//        fund.setName("天使基金");
//        fund.setPlatform("天使基金平台");
//        fund.setBallpark("大");
//        fund.setGrade(5);
//        fund.setBgrade(4);
//        fund.setManager("余豪");
//        fund.setMgrade(5);
        Fund fund1=fundDao.getFundBycolumn("fid","100003");
      fundDao.DelFund(fund1);
//        fundDao.AddFund(fund);


    }
}
