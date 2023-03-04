package lk.ijse.gdse.hibernate;


import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId("1L");
        customer.setName("Saman");
        customer.setAge(45);
        customer.setAddress("Galle");
        customer.setSalary(30000.00);

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);

        transaction.commit();
        session.close();

    }
}
