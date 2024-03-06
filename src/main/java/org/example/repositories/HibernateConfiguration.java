package org.example.repositories;

import org.example.entities.Book;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    public static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Book.class);
        return configuration;
    }
}
