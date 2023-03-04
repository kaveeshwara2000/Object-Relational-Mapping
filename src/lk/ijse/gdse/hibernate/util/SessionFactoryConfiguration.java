package lk.ijse.gdse.hibernate.util;

import lk.ijse.gdse.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        // creating the service registry
//        sessionFactory = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//
//        //creating metadata object
//        Metadata metadata = new MetadataSources(serviceRegistry)
//                .addAnnotatedClass(Customer.class)
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .build();
//
//        //creating the session factory
//        SessionFactory sessionFactory = metadata
//                .getSessionFactoryBuilder()
//                .build();

        sessionFactory =  new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance(){
       return (null==factoryConfiguration)
               ? factoryConfiguration = new SessionFactoryConfiguration()
               : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();

    }
}
