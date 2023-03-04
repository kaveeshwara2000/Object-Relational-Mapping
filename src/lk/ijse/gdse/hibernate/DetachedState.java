package lk.ijse.gdse.hibernate;

import lk.ijse.gdse.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachedState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration
                .getInstance()
                .getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(3L);

        NameIdentifier name = new NameIdentifier();
        name.setFirstName("kamal");
        name.setLastName("Surname");
        customer.setName(name);
        transaction.commit();

        System.out.println(customer); // Detached State

        session.close();

        Session session2 = SessionFactoryConfiguration
                .getInstance().getSession();

        Transaction transaction1 = session2.beginTransaction();

        session2.merge(customer); // persistent state

        transaction1.commit();

        session2.close();
    }
}
