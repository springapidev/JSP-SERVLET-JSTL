package com.coderbd.been;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBeen {

    private Student student;
    private String[] courseCompleted;

    public void saveStu() {
        String cc = "";
        for (String s : courseCompleted) {
            cc += s + ", ";
        }
        student.setCompletedCourse(cc);
        student.setRegiDate(new Date());

        StudentService service = new StudentService();
        service.saveStudent(student);
        System.out.println("Insert Success");
    }
 /*
    public void updateStu() {
        String cc = "";
        for (String s : courseCompleted) {
            cc += s + ", ";
        }
        student.setCompletedCourse(cc);
        student.setRegiDate(new Date());

        StudentService service = new StudentService();
        service.updateStudent(student);
        System.out.println("Update Success");
    }
  public void delStu() {      
        StudentService service = new StudentService();
        service.deleteStudent(student);
        System.out.println("Delete Success");
    }
    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }
*/
    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

}
