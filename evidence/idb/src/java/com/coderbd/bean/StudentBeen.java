package com.coderbd.bean;

import com.coderbd.domain.Student;
import com.coderbd.service.StudentService;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBeen {

    private Student student;
    
    private String[] checkedCourses;

    public void saveStudent() {
        String cc="";
        for(String s : checkedCourses){
        cc+=s+", ";
        }
        student.setCompletedCourse(cc);       
        
        StudentService service = new StudentService();
        service.save(student);
        System.out.println("Insert Success");
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

    public String[] getCheckedCourses() {
        return checkedCourses;
    }

    public void setCheckedCourses(String[] checkedCourses) {
        this.checkedCourses = checkedCourses;
    }

}
