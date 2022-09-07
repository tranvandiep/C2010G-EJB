/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.session;

import com.gokisoft.models.Student;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author DiepTV
 */
@Remote
public interface TestSessionBeanRemote {
    String getMessage(String msg);
    ArrayList<Student> getStudentList();
}
