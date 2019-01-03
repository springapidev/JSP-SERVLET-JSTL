package com.coderbd.service;

import com.coderbd.entity.Student;
import com.coderbd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public void saveStudent(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.save(s);
        tr.commit();
    }
    /* public void updateStudent(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(s);
        tr.commit();
    }
      public void deleteStudent(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(s);
        tr.commit();
    }
     */
}
