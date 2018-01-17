
import DAO.StudentDAO;

import Entity.StudentEntity;

import Page.StudentPage;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


/**
 * Created by ycbhci on 2017/6/26.
 */
public class Main {


    public static void main(final String[] args) throws Exception {

        Configuration configuration=new Configuration().configure();
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        String hql="from StudentEntity where name = '余豪' ";
        Query query=session.createQuery(hql);
        //query.setParameter(0,"余豪");
        List<StudentEntity> list=query.list();
        for(StudentEntity studentEntity : list)
        {
            //studentEntity.getId();
            System.out.print(studentEntity.getId()+"\t"+studentEntity.getName());

        }
        hql="update StudentEntity as c set name=:name where username =:username";

        session.beginTransaction();
        query=session.createQuery(hql);
       query.setParameter("name","李四");
       query.setParameter("username","root1");
       int n= query.executeUpdate();
       session.getTransaction().commit();
        System.out.print(n);





    }
}