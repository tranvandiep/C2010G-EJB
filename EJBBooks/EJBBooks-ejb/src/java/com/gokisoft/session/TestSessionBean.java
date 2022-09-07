/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.session;

import com.gokisoft.models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author DiepTV
 */
@Stateless
public class TestSessionBean implements TestSessionBeanRemote {

    @Override
    public String getMessage(String msg) {
        return "Xin chao > " + msg;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Student> getStudentList() {
        ArrayList<Student> dataList = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Student std = new Student("SV " + i, i + "@gmail.com", "Ha Noi");
            dataList.add(std);
        }
        
        return dataList;
    }
}
