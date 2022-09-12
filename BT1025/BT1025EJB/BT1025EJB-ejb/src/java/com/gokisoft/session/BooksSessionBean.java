/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.session;

import com.gokisoft.controller.BooksJpaController;
import com.gokisoft.controller.exceptions.RollbackFailureException;
import com.gokisoft.entities.Books;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DiepTV
 */
@Stateless
public class BooksSessionBean implements BooksSessionBeanRemote {
    EntityManagerFactory factory;
    BooksJpaController controller;
    
    public BooksSessionBean() {
        factory = Persistence.createEntityManagerFactory("BT1025EJB-ejbPU");
        controller = new BooksJpaController(factory);
    }
    
    @Override
    public List<Books> getBooks() {
        return controller.findBooksEntities();
    }

    @Override
    public void insert(Books books) {
        try {
            controller.create(books);
        } catch (Exception ex) {
            Logger.getLogger(BooksSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Books books) {
        try {
            controller.edit(books);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(BooksSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BooksSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            controller.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(BooksSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BooksSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
