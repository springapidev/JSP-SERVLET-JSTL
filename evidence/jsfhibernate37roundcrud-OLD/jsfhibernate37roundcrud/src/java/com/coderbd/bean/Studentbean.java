package com.coderbd.bean;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Studentbean {

    private StudentService service = new StudentService();
    private Student student;

    private List<Student> list;

    private String[] courseCompleted;

    public void save() {
        String cc = "";
        for (String s : courseCompleted) {
            cc += s + ", ";
        }
        student.setCompletedCourse(cc);
        service.saveOrUpdate(student);
    }

    public void edit() {
        service.saveOrUpdate(student);
    }

    public void del() {
        service.delete(student);
    }

    public Student searchById() {
        Student s = new Student();
        s = service.getById(student.getId());
        return s;
    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getList() {
        list = new ArrayList<>();
        list = service.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

}
