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
public class BookSessionBean implements BookSessionBeanRemote {
    EntityManagerFactory factory;
    BooksJpaController controller;
    
    public BookSessionBean() {
        factory = Persistence.createEntityManagerFactory("EJBBooks-ejbPU");
        controller = new BooksJpaController(factory);
    }
    
    @Override
    public List<Books> getBookList() {
        return controller.findBooksEntities();
    }

    @Override
    public void create(Books book) {
        try {
            controller.create(book);
        } catch (Exception ex) {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Books book) {
        try {
            controller.edit(book);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            controller.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
