package org.example.repositories;

import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public void addBook(Book book){
        var configuration = HibernateConfiguration.getConfiguration();
        try (SessionFactory sessionFactory
                     = configuration.buildSessionFactory()) {

            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        }
    }

    public List<Book> getByName(String name){
        var configuration = HibernateConfiguration.getConfiguration();
        try (SessionFactory sessionFactory
                     = configuration.buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            return session.createSelectionQuery("from Book where name like :name", Book.class)
                            .setParameter("name", name)
                            .getResultList();
        }
    }
}
