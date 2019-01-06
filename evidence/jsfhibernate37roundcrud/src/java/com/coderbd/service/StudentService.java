package com.coderbd.service;

import com.coderbd.entity.Student;
import com.coderbd.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
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
}
