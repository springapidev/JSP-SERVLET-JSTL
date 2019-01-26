package com.coderbd.service;

import com.coderbd.entity.Student;
import com.coderbd.util.HibernateUtil;
import static com.mchange.v2.c3p0.impl.C3P0Defaults.user;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public static void saveOrUpdate(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Success");
        tr.commit();
    }

    public static void delete(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        System.out.println("Delete Success");
        tr.commit();
    }

    @Transactional
    public static Student getById(int id) {
        Student student = new Student();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            student = (Student) session.get(Student.class, id);
            tr.commit();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }

        return student;
    }

    @Transactional
    public static List<Student> getList() {
        List<Student> students = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            students = session.createQuery("FROM Student").list();
            tr.commit();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }

        return students;
    }

    public static boolean getUserByUsernameAndPassword(String username, String password) {

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            Query query = session.createQuery("from Student where username=:username and password=:password");
            query.setString("username", username);
            query.setString("password", password);
            List list = query.list();
            System.out.println("list size " + list.size());
            if (list.size() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        return false;
    }

    
    
}
