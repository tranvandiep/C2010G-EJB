/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.session;

import com.gokisoft.controller.AuthorsJpaController;
import com.gokisoft.entities.Authors;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DiepTV
 */
@Stateless
public class AuthorSessionBean implements AuthorSessionBeanRemote {
    EntityManagerFactory factory;
    AuthorsJpaController controller;
    
    public AuthorSessionBean() {
        factory = Persistence.createEntityManagerFactory("BT1025EJB-ejbPU");
        controller = new AuthorsJpaController(factory);
    }
    
    @Override
    public List<Authors> getAuthors() {
        return controller.findAuthorsEntities();
    }
    
}
