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
public interface BookSessionBeanRemote {
    List<Books> getBookList();
    void create(Books book);
    void update(Books book);
    void delete(int id);
}
