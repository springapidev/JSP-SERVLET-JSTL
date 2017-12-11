package com.coderbd.service;

import com.coderbd.connection.DbConnection;
import com.coderbd.dao.PersonDAO;
import com.coderbd.domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajaul Islam
 */
public class PersonService implements PersonDAO {

    Connection conn = DbConnection.getConnection();

    /**
     *
     * @param p
     */
    @Override
    public void save(Person p) {
        try {
            if (p.getName() != null) {
                PreparedStatement stmt = conn.prepareStatement("insert into tbl_person(name) values(?)");

                stmt.setString(1, p.getName());
               

                int i = stmt.executeUpdate();
                System.out.println(i + " records inserted");
            }
            // con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Person p) {
        try {
            if (p.getId() != 0) {
               
                PreparedStatement stmt = conn.prepareStatement("update tbl_person SET name=? where id=?");
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getName());
              
                int i = stmt.executeUpdate();
                System.out.println(i + " records Updated");
            }
            // con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            if (id != 0) {
                PreparedStatement stmt = conn.prepareStatement("delete from tbl_person where id=?");

                stmt.setInt(1, id);

                int i = stmt.executeUpdate();
                System.out.println(i + " records Deleted");
            }
            // con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try {
            Person p;
            PreparedStatement stmt = conn.prepareStatement("select *from tbl_person");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p = new Person();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
              
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Person getPerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
