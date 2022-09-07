/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft;

import com.gokisoft.entities.Books;
import com.gokisoft.models.Student;
import com.gokisoft.session.BookSessionBeanRemote;
import com.gokisoft.session.TestSessionBeanRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author DiepTV
 */
public class Main {
    @EJB
    private static BookSessionBeanRemote bookSessionBean;
    
    @EJB
    private static TestSessionBeanRemote testSessionBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ket qua > " + testSessionBean.getMessage("Aptech"));
        
        ArrayList<Student> dataList = testSessionBean.getStudentList();
        
        for (Student std : dataList) {
            System.out.println(std);
        }
        
        List<Books> bookList = bookSessionBean.getBookList();
        for (Books book : bookList) {
            System.out.println(book);
        }
    }
    
}
