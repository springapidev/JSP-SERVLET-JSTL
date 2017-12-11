/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.dao;

import com.coderbd.domain.Person;
import java.util.List;

/**
 *
 * @author Rajail Islam
 */
public interface PersonDAO {

     void save(Person p);

    void update(Person p);

    void delete(int id);

    List<Person> getPersons();

    Person getPerson(int id);
}
