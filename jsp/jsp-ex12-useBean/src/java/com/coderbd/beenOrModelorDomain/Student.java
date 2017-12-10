/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.beenOrModelorDomain;

/**
 *
 * @author Rajail Islam
 */
public class Student {
    private int id;
    private String name;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * jsp:useBean action tag

    jsp:useBean action tag
    Syntax of jsp:useBean action tag
    Attributes and Usage of jsp:useBean action tag
    Simple example of jsp:useBean action tag

The jsp:useBean action tag is used to locate or instantiate a bean class. If bean object of the Bean class is already created, it doesn't create the bean depending on the scope. But if object of bean is not created, it instantiates the bean.
Syntax of jsp:useBean action tag

    <jsp:useBean id= "instanceName" scope= "page | request | session | application"   
    class= "packageName.className" type= "packageName.className"  
    beanName="packageName.className | <%= expression >" >  
    </jsp:useBean>  

Attributes and Usage of jsp:useBean action tag

    id: is used to identify the bean in the specified scope.
    scope: represents the scope of the bean. It may be page, request, session or application. The default scope is page.
        page: specifies that you can use this bean within the JSP page. The default scope is page.
        request: specifies that you can use this bean from any JSP page that processes the same request. It has wider scope than page.
        session: specifies that you can use this bean from any JSP page in the same session whether processes the same request or not. It has wider scope than request.
        application: specifies that you can use this bean from any JSP page in the same application. It has wider scope than session.
    class: instantiates the specified bean class (i.e. creates an object of the bean class) but it must have no-arg or no constructor and must not be abstract.
    type: provides the bean a data type if the bean already exists in the scope. It is mainly used with class or beanName attribute. If you use it without class or beanName, no bean is instantiated.
    beanName: instantiates the bean using the java.beans.Beans.instantiate() method.

     */
    
}
