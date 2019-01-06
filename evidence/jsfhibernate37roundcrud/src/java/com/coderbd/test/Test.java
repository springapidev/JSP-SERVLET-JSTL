/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.test;

import com.coderbd.entity.Student;
import com.coderbd.service.StudentService;
import java.util.List;

/**
 *
 * @author User
 */
public class Test {

    public static void main(String[] args) {
        StudentService service = new StudentService();
        //  Student student = new Student();
        //   student.setId(2);
//        student.setName("Moly Jolu");
//        student.setRound("Round-37");
//        student.setCompletedCourse("Js, Java");
//        student.setGender("F");
//        service.saveOrUpdate(student);

//service.delete(student);
        //  Student student = service.getById(2);
        //    System.out.println(student);
        List<Student> list = service.getList();
        System.out.println("size: " + list.size());
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
