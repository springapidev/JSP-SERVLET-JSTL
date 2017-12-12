package com.coderbd.service;

import com.coderbd.conn.DbConnection;
import com.coderbd.dao.StudentDao;
import com.coderbd.domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author J2EE-33
 */
public class StudentService implements StudentDao {

    Connection conn = DbConnection.getConnection();

    @Override
    public void save(Student s) {

        try {
            if (s.getName() != null) {
                PreparedStatement pstm = conn.prepareStatement("insert into student(name) values(?)");
                pstm.setString(1, s.getName());

                pstm.executeUpdate();
                System.out.println(" sucess");

            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Student s) {

        try {
            if (s.getId() != 0) {
                PreparedStatement pstm = conn.prepareStatement("update student set name=? where id=?");
                pstm.setString(1, s.getName());
                pstm.setInt(2, s.getId());

                pstm.executeUpdate();
                System.out.println(" updated succc......");

            }
        } catch (Exception e) {
        }
    }

}
