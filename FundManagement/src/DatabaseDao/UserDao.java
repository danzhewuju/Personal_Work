package DatabaseDao;

import Entity.UserEntity;
import Page.User;
import Unit.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Alx on 2017/7/26.
 */
public class UserDao {


    public UserDao() {
    }

    public User getUserBycolumn(String column, String key)
    {

        User user=null;
        Session session= HibernateUtils.getSession();
      String hql="from UserEntity where "+ column +" = "+ "'"+key+"'";
        List<UserEntity> s=session.createQuery(hql).list();
        if(s.size()>0)
        {
           user=new User();
           user.setUid(s.get(0).getUid());
           user.setPassword(s.get(0).getPassword());
           user.setAccount(s.get(0).getAccount());

        }
        HibernateUtils.closeSession(session);
        return user;
    }


}
