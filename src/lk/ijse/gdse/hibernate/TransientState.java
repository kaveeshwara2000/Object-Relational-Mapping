package lk.ijse.gdse.hibernate;
import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransientState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration
                .getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer(); // Transient state
        customer.setAddress("Transient");
        customer.setAge(28);

        session.save(customer); // persistent state

        customer.setSalary(40000.00);

        transaction.commit();
        session.close();

    }
}
