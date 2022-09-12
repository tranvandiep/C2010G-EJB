/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gokisoft.session;

import com.gokisoft.entities.Books;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author DiepTV
 */
@Remote
public interface BooksSessionBeanRemote {
    List<Books> getBooks();
    void insert(Books books);
    void update(Books books);
    void delete(int id);
}
